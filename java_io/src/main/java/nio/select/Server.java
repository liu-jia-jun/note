package nio.select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

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
            if(selector.select(1000)==0){
                System.out.println("服务器等待1秒,无连接");
                continue;
            }
            /*

            如果返回值 > 0 表示获取到相关的  selectionKey集合




             */

            Set<SelectionKey> selectionKeys = selector.selectedKeys();


            // 遍历 selecttionKeys 使用迭代器遍历
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            // 使用while循环来遍历 selectionkey
            while(iterator.hasNext()){
                // 获取到 SelectionKey,之后根据SelectionKey的关联事件,进行相关的业务处理
                SelectionKey key= iterator.next();

                if(key.isAcceptable()){
                    // 如果是 OP_ACCEPT 表示 有新的客户端连接,为改客户端生成一个SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    // 将socketChannel 注册到 selector,关注事件为OP_READ ,同时给 socketChannel 关联一个 Buffer 用于数据的读写操作
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                if(key.isReadable()){
                    // 如果是 OP_READ 事件 表示有读操作 通过 key 反向获取对应的 SocketChannel
                    SocketChannel channel = (SocketChannel)key.channel();

                    ByteBuffer buffer = (ByteBuffer) key.attachment();

                    buffer.clear();
                    channel.read(buffer);
                    System.out.println("客户端输出:  "+ new String(buffer.array()));

                }
                // 手动将已经处理过的selectionKey从当前set集合中移除, 防止重复操作
                iterator.remove();



            }


        }
    }
}
