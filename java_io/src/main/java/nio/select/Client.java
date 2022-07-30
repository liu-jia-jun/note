package nio.select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author 刘佳俊
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // 得到一个网络通道
        SocketChannel  socketChannel = SocketChannel.open();
        // 设置非阻塞
        socketChannel.configureBlocking(false);
        // 提供服务端的IP 和 端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
        // 连接服务器
        if(!socketChannel.connect(inetSocketAddress)){
            while(!socketChannel.finishConnect()){
                System.out.println("连接服务器需要时间,客户端不会阻塞,可以完成其他业务");
            }
        }
        // 如果连接成功,就发送数据

        String str = "hello world";
        // wraps a byte array into a buffer , 创建一个str个字节大小的buffer 并将 str 的字节数组放入到buffer中
        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());


        // 发送数据 , 将 buffer 中的数据写入到 channel 中
        socketChannel.write(buffer);
        System.in.read();



    }
}
