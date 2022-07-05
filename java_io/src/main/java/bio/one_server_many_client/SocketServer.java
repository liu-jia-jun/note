package bio.one_server_many_client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 刘佳俊
 *
 * 实现服务端可以同时接收多个客户端的Socket通信需求
 *
 * 思路: 当服务端没接收到一个客户端Socket请求对象之后都交给一个独立的线程处理
 *
 *
 */
public class SocketServer {


    public static void main(String[] args) throws IOException {
        // 1. 注册端口
        ServerSocket serverSocket = new ServerSocket(9999);

        // 2. 定义一个死循环,负责不断接收客户端的Socket连接请求
        while(true){
            // 接收客户的请求并返回一个socket对象
            Socket socket = serverSocket.accept();

            // 开启一个新线程,并将 接收到的客户端的请求对象socket交给这个线程进行后续的处理
            new ServerThreadReader(socket).start();
        }
    }

}
