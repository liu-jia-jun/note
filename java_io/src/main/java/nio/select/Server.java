package nio.select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @author 刘佳俊
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 创建 ServerSocketChannel  相当于 ServerSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 获取一个 Selector 对象
        Selector selector = Selector.open();

        // 绑定一个端口 , 即监听该端口 来获取客户端的连接

        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        // 设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        // 将serverSocketChannel  注册到 selector 中 ,关联事件为 OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 循环监听端口等待客户端的连接

        while(true){

        }
    }
}
