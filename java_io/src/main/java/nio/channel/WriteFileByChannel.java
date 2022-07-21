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
        FileOutputStream fileOutputStream = new FileOutputStream("./java_io/src/main/resources/file.txt");

        FileChannel channel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        byteBuffer.put(str.getBytes());

        byteBuffer.flip();

        channel.write(byteBuffer);
        System.out.println("finish");
        fileOutputStream.close();
        channel.close();



    }

}
