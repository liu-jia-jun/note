package shangguigu.first;

/**
 * @author 刘佳俊
 *
 * 单例模式实例
 * 饿汉式
 *      使用枚举来实现
 */
public enum  _03_Singleton2 {

    FIRST,SECOND,THIRD;
    _03_Singleton2(){
        System.out.println("当我们调用这个枚举是,你当中有多少个枚举变量就有多少个该对象的实例,就调用了多少次无参构造方法");
    }
}
