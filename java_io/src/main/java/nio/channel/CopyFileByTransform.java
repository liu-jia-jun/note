package nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author 刘佳俊
 */
public class CopyFileByTransform {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("./java_io/src/main/resources/1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("./java_io/src/main/resources/2.jpg");
        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannle = fileOutputStream.getChannel();
        outputChannle.transferFrom(inputChannel,0,inputChannel.size());
        fileInputStream.close();
        fileOutputStream.close();
    }
}
