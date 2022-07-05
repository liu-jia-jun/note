package bio.one_server_many_client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 刘佳俊
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {

        // 1. 请求与服务器的Socket对象连接
        Socket socket  = new Socket("127.0.0.1",9999);

        // 2. 得到一个打印流
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        // 3. 使用循环不断的发送消息给服务端接收
        Scanner scanner = new Scanner(System.in);

        String message;
        while(true){
            System.out.println("请输入需要发送的消息:");
            message= scanner.nextLine();
            // 4. 服务段接收数据时是按行接收,所以这里必须是println 需要换行
            printStream.println(message);

            // 流的刷新
            printStream.flush();
        }

    }
}


























