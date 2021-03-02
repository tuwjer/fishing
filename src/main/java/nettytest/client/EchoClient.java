package nettytest.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class EchoClient {

    private final String host;

    private final int port;

    public EchoClient(String host,int port){
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception{
        final EchoClientHandler echoClientHandler = new EchoClientHandler();
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host,port)).handler(echoClientHandler);
            ChannelFuture channelFuture = bootstrap.connect().sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            eventLoopGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        new EchoClient("127.0.0.1",10022).start();
    }
}
