package shangguigu.first;

/**
 * @author 刘佳俊
 *
 * 局部变量和成员变量
 *
 *  生命周期
 *       局部变量: 每一个线程,每一次调用执行的都是新的生命周期
 *       实例变量: 随着对象的创建而初始化,随着对象的被回收而消亡,每个对象的实例变量都是独立的
 *       类变量: 随着类的初始化而初始化,随着类的卸载而消亡,该类的所有的类变量都是共享的
 *
 *  值存储的位置
 *       局部变量:栈
 *       实例变量:堆
 *       类变量:方法区
 *
 *
 */
public class _10_Variables {
    static int s;
    int i;
    int j;
    {
        int i=1;
        i++;
        j++;
        s++;
    }
    public void test(int j){
        i++;
        j++;
        s++;
    }

    public static void main(String[] args) {
        _10_Variables variables1 = new _10_Variables();
        _10_Variables variables2 = new _10_Variables();
        variables1.test(10);
        variables1.test(20);
        variables2.test(30);
        System.out.println(variables1.i+","+variables1.j+","+ _10_Variables.s);
        System.out.println(variables2.i+","+variables2.j+","+ _10_Variables.s);
    }

}
