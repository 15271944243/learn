package xxx.test;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * netty入门:http://ifeve.com/netty5-user-guide/
 */
public class Server{

    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void run(){
        // NioEventLoopGroup 是用来处理I/O操作的多线程事件循环器，
        // Netty提供了许多不同的EventLoopGroup的实现用来处理不同传输协议。
        // 在这个例子中我们实现了一个服务端的应用，因此会有2个NioEventLoopGroup会被使用。
        // 第一个经常被叫做‘boss’，用来接收进来的连接。
        // 第二个经常被叫做‘worker’，用来处理已经被接收的连接，一旦‘boss’接收到连接，就会把连接信息注册到‘worker’上。
        // 如何知道多少个线程已经被使用，如何映射到已经创建的Channels上都需要依赖于EventLoopGroup的实现，并且可以通过构造函数来配置他们的关系
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            // ServerBootstrap 是一个启动NIO服务的辅助启动类。你可以在这个服务中直接使用Channel，
            // 但是这会是一个复杂的处理过程，在很多情况下你并不需要这样做
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    // 这里我们指定使用NioServerSocketChannel类来举例说明一个新的Channel如何接收进来的连接
                    .channel(NioServerSocketChannel.class)
                    // 这里的事件处理类经常会被用来处理一个最近的已经接收的Channel。
                    // ChannelInitializer是一个特殊的处理类，他的目的是帮助使用者配置一个新的Channel
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // 解决TCP拆包黏包问题
                            // 设置特殊分隔符
                            ByteBuf buf = Unpooled.copiedBuffer("$_".getBytes());
                            socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,buf));
                            // 设置字符串形式解码(这样接收消息时就可以用String了)
                            // socketChannel.pipeline().addLast(new StringDecoder());
                            socketChannel.pipeline().addLast(new ServerHandler());
                        }
                    })
                    // 你可以设置这里指定的通道实现的配置参数。
                    // 我们正在写一个TCP/IP的服务端，因此我们被允许设置socket的参数选项比如tcpNoDelay和keepAlive
                    .option(ChannelOption.SO_BACKLOG,128)
                    // option()是提供给NioServerSocketChannel用来接收进来的连接。childOption()是提供给由父管道ServerChannel接收到的连接
                    .childOption(ChannelOption.SO_KEEPALIVE,true);

            ChannelFuture f = b.bind(port).sync();
            f.channel().closeFuture().sync();
            // 可以绑定多个端口
            /*ChannelFuture f2 = b.bind(8764).sync();
            f2.channel().closeFuture().sync();*/
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new Server(8765).run();
    }
}
