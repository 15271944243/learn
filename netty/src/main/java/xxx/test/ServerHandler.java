package xxx.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

public class ServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        try {
            byte[] data = new byte[buf.readableBytes()];
            buf.readBytes(data);
            String request = new String(data, "utf-8");
            System.out.println("Server: " + request);
            // 写给客户端
            String response = "我是回复001$_";
            // 如果调用了write,就不用去释放msg了
            ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));//.addListener(ChannelFutureListener.CLOSE);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
