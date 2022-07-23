package nio.channel;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 刘佳俊
 *
 *
 */
public class ReadAndWriteFileByChannel {
    public static void main(String[] args) throws IOException {


        // 文件输入流并且获取Channel通道, inChannel 与file文件绑定,可以将文件中的内容通过inChannel读出来
        FileInputStream fileInputStream = new FileInputStream("./java_io/src/main/resources/file.txt");
        FileChannel inChannel = fileInputStream.getChannel();



        // 文件输出流并获取Channel通道, outChannel 与fileCopy文件绑定,可以将文件中的内容通过inChannel写进去
        FileOutputStream fileOutputStream = new FileOutputStream("./java_io/src/main/resources/fileCopy.txt");
        FileChannel outChannel = fileOutputStream.getChannel();


        // 获取一个10字节大小的ByteBuffer缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);


         /*
            1. inChannel将文件内容读入到ByteBuffer中
            2. outChannel从ByteBuffer中读取数据并且写入到fileCopy文件中
            3. 循环往复,直至文件中内容读完
         */
        while(true){
            int read = inChannel.read(buffer);
            if(read==-1){
                break;
            }
            // buffer转换为读数据模式
            buffer.flip();
            outChannel.write(buffer);
            // 清空buffer缓存,即重置 position和limit 重新进入写数据模式
            // 因为读完数据之后 position 和 limit 相等无法再写入数据所以需要 执行 clear()方法
            buffer.clear();

        }

    }
}
