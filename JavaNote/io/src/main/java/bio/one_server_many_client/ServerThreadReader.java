package bio.one_server_many_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author 刘佳俊
 *
 * 多线程
 *
 * 在服务端每次接收到一个客户端的请求是都创建一个新的线程用于对客户端的请求进行处理
 *
 * 这里是继承Thread类并重写run方法实现多线程的
 *
 *
 */
public class ServerThreadReader extends Thread{
    private Socket socket;
    public ServerThreadReader(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run(){
        try {

            System.out.println("这是一个新的线程");

            // 从socket对象中得到一个字节输入流用于得到客户端发送的消息
            InputStream inputStream = socket.getInputStream();
            // 使用缓冲字符输入流包装字节输入流 , 使其更加高效的输出
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg ;
            while((msg = bufferedReader.readLine())!=null){
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
