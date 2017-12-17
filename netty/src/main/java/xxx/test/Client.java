package xxx.test;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;

public class Client {

    public static void main(String[] args) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // 解决TCP拆包黏包问题
                            // 设置特殊分隔符
                            ByteBuf buf = Unpooled.copiedBuffer("$_".getBytes());
                            socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,buf));
                            // 设置字符串形式解码(这样接收消息时就可以用String了)
                            // socketChannel.pipeline().addLast(new StringDecoder());
                            socketChannel.pipeline().addLast(new ClientHandler());
                        }
                    });
            ChannelFuture cf = b.connect("127.0.0.1",8765).sync();
            // 这样发送三次,在server段其实还是相当于一次(这就是TCP拆包黏包问题)
            // 有三种解决方案：1.消息定长,例如每个报文的大小固定200个字节,不够长的用空格补
            // 2.在报文尾部增加特殊字符进行分隔
            // 3.将消息分为消息头和消息体,在消息头中包含消息总长度字段
            // 在netty里,通过DelimiterBasedFrameDecoder(自定义分隔符)
            // 和FixedLengthFrameDecoder(定长)去实现,详见Server端

            cf.channel().writeAndFlush(Unpooled.copiedBuffer("xxx1$_".getBytes()));
            cf.channel().writeAndFlush(Unpooled.copiedBuffer("xxx2$_".getBytes()));
            cf.channel().writeAndFlush(Unpooled.copiedBuffer("xxx3$_".getBytes()));
            cf.channel().closeFuture().sync();
            /*ChannelFuture cf2 = b.connect("127.0.0.1",8764).sync();
            cf2.channel().writeAndFlush(Unpooled.copiedBuffer("hello world".getBytes()));
            cf2.channel().closeFuture().sync();*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
