package shangguigu.first;

/**
 * @author 刘佳俊
 * 单例模式实例
 * 饿汉式
 * 直接创建实例对象,不管你是否需要这个对象,通过私有化构造器实现
 *
 *
 * 1. 构造器私有化
 * 2. 自行创建,并使用静态变量保存
 * 3. 向外提供该实例,可以直接使用public 修饰,也可以使用get方法向外提供该静态变量
 * 4. 强调这个是单例,我们可以使用final修改
 */
public class _02_Singleton1 {
    // 使用静态遍历存储该对象并向外提供
    public static final _02_Singleton1 SINGLETON_1 = new _02_Singleton1();

    //    构造器私有化
    private _02_Singleton1() {
    }
}
