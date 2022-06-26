package shangguigu.first;

/**
 * @author 刘佳俊
 * <p>
 * 单例模式
 * <p>
 * 懒汉式
 * 在该类中提供一个获取该对象实例的方式,在方法中返回实例,只有当该方法被调用的时候才会创建实例对象
 * <p>
 * 1. 私有化构造器,不让类的外部能创建实例
 * 2. 提供一个静态变量来保存这个唯一的实例
 * 3. 提供一个静态的方式,用于获取这个唯一的对象
 */
public class _05_Singleton4 {

    private static _05_Singleton4 singleton4;

    private _05_Singleton4() {
    }

    public static _05_Singleton4 getSingleton4() {
        if (singleton4 == null) {// 优化,如果多线程进入,先判断是否空,如果不为空,则可以减少锁运行的时间,减少线程等待
            synchronized (_05_Singleton4.class) {// 加锁防止多线程
                if (singleton4 == null) {// 判断实例是否被创建,
                    singleton4 = new _05_Singleton4();
                }
            }
        }
        return singleton4;
    }
}
