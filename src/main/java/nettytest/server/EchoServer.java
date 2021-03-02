package nettytest.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {

    private final int port;

    public EchoServer(int port){
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        new EchoServer(10022).start();
    }

    public void start() throws Exception{
        final EchoServerHandler echoServerHandler = new EchoServerHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group).channel(NioServerSocketChannel.class)
                    .localAddress(port).childHandler(echoServerHandler);
            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully().sync();
        }
    }
}
