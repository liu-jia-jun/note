package nio.buffer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author 刘佳俊
 *
 * Scattering: 将数据写入到 buffer时 采用 buffer 数组, 依次写入 称为 Buffer分散
 *
 * Gathering: 从 buffer中读取数据时, 采用 buffer 数组 依次读入 称为 buffer 聚合
 *
 */
public class ScatteringAndGatheringTest {
    public static void main(String[] args) throws IOException {
        // 这里我们使用 ServerSocketChannel 和 SocketChannel  网络通道

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        // 绑定端口到socket中 并启动
        serverSocketChannel.socket().bind(inetSocketAddress);

        // 创建 buffer数组
        ByteBuffer[] buffers = new ByteBuffer[2];

        buffers[0] = ByteBuffer.allocate(5);
        buffers[1] = ByteBuffer.allocate(3);

        // 进行客户端的连接(telnet)
        SocketChannel socketChannel = serverSocketChannel.accept();

        // 假定 从客户端接收8个字节
        int messageLength = 8;

        // 循环读取
        while (true) {
            int byteRead = 0;
            while (byteRead < messageLength) {
                long l = socketChannel.read(buffers);
                byteRead += l;// 累加读取的字节数
                System.out.println("byteRead=" + byteRead);

                // 使用流打印, 看看当前的这个buffer 的 position和limit
                Arrays.asList(buffers).stream()
                        .map(buffer -> "position=" + buffer.position() + ",limit=" + buffer.limit()).forEach(System.out::println);
            }
            //将所有的buffer进行flip
            Arrays.asList(buffers).forEach(buffer -> buffer.flip());
            long byteWrite = 0;
            while (byteWrite < messageLength) {
                long l = socketChannel.write(buffers);
                byteWrite += l;
            }
            Arrays.asList(buffers).forEach(byteBuffer -> {
                byteBuffer.clear();
            });

            System.out.println("byteRead="+byteRead+" byteWrite= "+byteWrite+", messageLength "+messageLength);

        }


        //


    }
}
