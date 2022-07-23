package nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 刘佳俊
 *
 * MappedByteBuffer  可以让文件直接再内存中(堆外内存,系统内存)修改,操作系统不需要拷贝一次
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("./java_io/src/main/resources/file.txt","rw");

        FileChannel channel = randomAccessFile.getChannel();

        /*
        参数:
            参数1. FileChannel.MapMode.READ_WRITE 使用的都写模式
            参数2. 0 可以进行直接修改的其实位置
            参数3. 5 是映射到内存的大小而不是索引位置,即 file.txt 有多少个字节映射到内存中,这些映射到内存中的字节内容是可以直接修改的

        可以直接修改的范围是0~5  即下标为 [0,4]

        注意MappedByteBuffer 的实际类型是DirectByteBuffer

         */


        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE,0,5);
        mappedByteBuffer.put(0,(byte) '1');
        mappedByteBuffer.put(1,(byte) '1');
        mappedByteBuffer.put(2,(byte) '1');
        mappedByteBuffer.put(3,(byte) '1');
        mappedByteBuffer.put(4,(byte) '1');
        System.out.println("修改成功");
        randomAccessFile.close();
    }
}
