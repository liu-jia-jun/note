package shangguigu.first;

import java.io.IOException;
import java.util.Properties;

/**
 * @author 刘佳俊
 *
 * 饿汉式
 *      通过静态代码块来实现单例模式
 *
 * 区别于第一种饿汉式直接创建对象,这里可以向创建的实例对象中注入配置文件中的值
 *
 *
 *
 *
 */
public class _04_Singleton3 {
    public static  _04_Singleton3 SINGLETON_3=null;
    private String info;
    static {
        try {
            // 创建流对象并获取single.properties中的值
            Properties properties = new Properties();
            properties.load(_04_Singleton3.class.getClassLoader().getResourceAsStream("single.properties"));
            SINGLETON_3 = new _04_Singleton3(properties.getProperty("info"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private _04_Singleton3(String info){
        this.info = info;
    }

    @Override
    public String toString() {
        return "info=" + info
                ;
    }
}
