package bio.pseudo_asynchronous;

/**
 * @author 刘佳俊
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 目标：开发实现伪异步通讯架构
 * 思路：服务端没接收到一个客户端socket请求对象之后都交给一个独立的线程来处理客户端的数据交互需
 求
 */
public class Server {
    public static void main(String[] args) {
        try {
            //1.注册端口
            ServerSocket ss = new ServerSocket(9999);
            //2.定义一个死循环，负责不断的接收客户端的Socket的连接请求
            //初始化一个线程池对象

            HandlerSocketServerPool pool = new HandlerSocketServerPool(3, 10);
            while (true) {
                Socket socket = ss.accept();
                //3.把socket对象交给一个线程池进行处理
                //把socket封装成一个任务对象交给线程池处理
                Runnable target = new ServerRunnableTarget(socket);
                pool.execute(target);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
