package nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 刘佳俊
 */
public class ReadFileByChannel {
    public static void main(String[] args) throws IOException {

        File file = new File("./java_io/src/main/resources/file.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate((int) file.length());

        channel.read(buffer);
        System.out.println(new String(buffer.array()));
        fileInputStream.close();

    }
}
