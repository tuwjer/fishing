package nettytest.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

public class ByteBufTest {

    public void ByteBufMethod1(){
        ByteBuf heapBuf = null;
        if(heapBuf.hasArray()){
            byte[] array = heapBuf.array();
            int offset = heapBuf.arrayOffset() + heapBuf.readerIndex();
            int length = heapBuf.readableBytes();
        }
    }

    public void ByteBufMethod2(){
        ByteBuf directBuf = null;
        if(!directBuf.hasArray()){
            int length = directBuf.readableBytes();
            byte[] array = new byte[length];
            directBuf.getBytes(directBuf.readerIndex(),array);
        }
        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();
        compositeByteBuf.addComponents();
        compositeByteBuf.removeComponent(0);
        int length = compositeByteBuf.readableBytes();
        compositeByteBuf.capacity();
    }
}
