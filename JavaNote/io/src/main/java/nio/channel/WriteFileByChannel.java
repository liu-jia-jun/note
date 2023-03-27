package nio.channel;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author 刘佳俊
 */
public class WriteFileByChannel {
    public static void main(String[] args) throws IOException {
        String str = "happy everyday to me";

        // 创建一个文件输出流,将内容输出到文件中,没有该文件就创建
        FileOutputStream fileOutputStream = new FileOutputStream("./java_io/src/main/resources/file.txt");

        // 通过文件输出流FileOutputStream 获得一个文件通道 FileChannel
        FileChannel channel = fileOutputStream.getChannel();

        // 创建一个缓冲区 ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 将 字符串 str 以字节的形式放入到缓冲区中
        byteBuffer.put(str.getBytes());

        // 对byteBuffer 进行flip 重置position 和limit 进入到读取数据的模式
        byteBuffer.flip();

        // 将缓冲区中的内容写到通道中
        channel.write(byteBuffer);
        System.out.println("finish");
        // 对流进行关闭,注意 这里的channel是包含在FileOutputStream之内的
        fileOutputStream.close();



    }

}
