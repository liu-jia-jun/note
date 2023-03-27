/**
 * @author 刘佳俊
 */

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;


public class Provider {

    // 生产者生产消息

    public static void main(String[] agrs) throws IOException, TimeoutException {
        // 创建连接mq 的连接工厂对象
        ConnectionFactory factory = new ConnectionFactory();
        // 设置连接的rabbitmq主机
        factory.setHost("localhost");
        // 设置端口号
        factory.setPort(5672);
        // 设置需要连接的虚拟主机
        factory.setVirtualHost("/test");
        // 设置连接虚拟主机时需要的用户名和密码，虚拟主机需要和用户绑定之后才能访问，guest用户可以访问所有虚拟主机
        factory.setUsername("user");
        factory.setPassword("password");
        // 获取连接对象
        Connection connection = factory.newConnection();
        // 通过连接创建通道，消息通过通道传输给虚拟主机
        Channel channel = connection.createChannel();
        /**
         * 通道绑定对应的消息队列
         *
         * 参数一：队列名称，如果队列不存在会自动创建
         * 参数二：用于定义队列特性，是否需要持久化，持久化到磁盘中，true为持久化，false为不持久化
         * 参数三：exclusive 设置是否独占队列，true为独占队列，其他连接无法访问该队列，false为不独占
         * 参数四：autoDelete 设置队列在消费完之后是否自动删除该队列，true为删除，false为不删除
         * 参数五：额外附加参数
         */
        channel.queueDeclare("test",false,false,false,null);

        // 发布消息
        // 参数1：交换机名称 参数2：队列名称 参数三，消息传递的额外设置，参数4：消息的具体内容
        for (int i = 0; i < 100; i++) {
            channel.basicPublish("","test", null,("hello 张"+i).getBytes(StandardCharsets.UTF_8));
        }

        channel.close();
        connection.close();

    }
}