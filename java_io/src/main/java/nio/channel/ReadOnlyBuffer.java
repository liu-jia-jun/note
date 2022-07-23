package nio.channel;

import java.nio.ByteBuffer;

/**
 * @author 刘佳俊
 *
 * Buffer的不同类型 只读Buffer
 *
 */
public class ReadOnlyBuffer {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);



        for (int i=0;i<byteBuffer.limit();i++){
            // 注意byteBuffer 理应放入byte类型的数据,但是这里是可以放入其他类型数据,同时需要注意取数据的时候也要按照类型取出
            byteBuffer.put((byte) i);
        }

        // 转换为读模式
        byteBuffer.flip();

        // 得到一个只读的Buffer

        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        // 得到的是一个新的实例一个只读的实例
        System.out.println(byteBuffer==readOnlyBuffer);


    }
}
