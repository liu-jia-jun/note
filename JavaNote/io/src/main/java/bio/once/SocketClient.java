package bio.once;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author 刘佳俊
 *
 * 网络通信客户端
 *
 * 实现客户端单次发送,服务端单次接收打印
 *
 *
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        // 1. 创建Socket对象并设置主机和端口号,请求服务器的连接
        Socket socket = new Socket("127.0.0.1",9999);
        // 2. 从Socket对象中获取一个字节输出流
        OutputStream outputStream = socket.getOutputStream();
        // 3. 把字节输出流包装成一个打印流
        // 因为在BIO的同步阻塞模型中,服务端和客户端的发送接收情况需要一致
        PrintStream printStream = new PrintStream(outputStream);
        // 4. 服务段接收数据时是按行接收,所以这里必须是println 需要换行
        printStream.println("hello Service");


        // 流的刷新和关闭
        printStream.flush();
        printStream.close();
    }
}
