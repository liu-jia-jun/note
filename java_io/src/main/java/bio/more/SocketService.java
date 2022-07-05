package bio.more;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 刘佳俊
 *
 * 网络通信服务端 用于接收客户端发送的消息
 *
 * 实现客户端多次发送,服务端多次接收打印
 *
 */
public class SocketService {
    public static void main(String[] args) throws IOException {

        // 1. 定义一个ServerSocket对象进行服务端的端口注册,用来监听本机的9999端口
        ServerSocket serverSocket = new ServerSocket(9999);

        // 2. 监听客户端的连接请求
        Socket socket = serverSocket.accept();

        // 3. 从socket管道中得到一个字节流输入对象
        InputStream inputStream = socket.getInputStream();
        // 4. 把字节输入流包装成一个缓冲字符输入流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String message;
        while ((message = bufferedReader.readLine())!=null){
            System.out.println(message);
        }

    }

}
