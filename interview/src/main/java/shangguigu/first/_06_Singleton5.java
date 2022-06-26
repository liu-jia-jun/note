package shangguigu.first;

/**
 * @author 刘佳俊
 * <p>
 * 在内部类被加载和初始化时才创建实例对象
 * 静态内部类不会自动随外部类的加载和初始化而初始化的,它需要单独加载和初始化
 */
public class _06_Singleton5 {
    private _06_Singleton5() {
    }

    public static _06_Singleton5 getInstance() {
        return Inner.SINGLETON_5;
    }


    // 静态内部类
    private static class Inner {
        private static final _06_Singleton5 SINGLETON_5 = new _06_Singleton5();
    }

}
