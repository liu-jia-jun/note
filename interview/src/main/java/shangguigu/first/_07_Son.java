package shangguigu.first;

/**
 * @author 刘佳俊
 *
 *
 * 类的初始化和实例的初始化
 *
 *  类初始化过程
 *      1. 一个类创建按实例需要先加载并初始化该类
 *          注意: main 方法所在的类需要先加载和初始化
 *      2. 一个子类需要初始化就需要先初始化父类
 *      3. 一个类的初始化就是执行了<clinit>() 方法
 *          <clinit>()方法由静态类变量显示赋值代码和静态代码块组成
 *          类变量显示赋值代码和静态代码块从上到下顺序执行
 *          <clinit>() 方法只执行一次
 *
 *
 *  实例初始化过程
 *          1. 实例化过程就是执行<init>()方法
 *              <init>()方法可能重载有多个,有几个构造器就有几个<init>()方法
 *              <init>()方法由非静态实例变量显示赋值代码和非静态代码块,对应构造器代码块组成
 *              非静态实例变量显示赋值代码块和非静态代码块从上到下顺序执行,而对应的构造器代码块最后执行
 *              每次创建实例对象,调用对应构造器,对应执行的就是<init>()方法
 *              <init>()方法首行是super()或者super(实参列表) 即对应父类中的 <init>()方法,
 *              所以说,子类的<init>()方法中会首先调用父类中的<init>()方法
 *
 *
 *
 *
 *  方法的重写Override
 *      不能被重写的方法
 *          1. final 方法
 *          2. 静态方法
 *          3. private等子类中不可见方法
 *       对象的多态性
 *          1. 子类如果重写了父类的方法,通过子类对象调用的一定是子类重写过的代码
 *          2. 非静态方法默认的调用对象是this
 *          3. this对象在构造器或者说<init>方法中就是正在创建的对象
 *
 *
 *
 */
public class _07_Son extends Father{
    private int i = test();
    private static int j = method();
    static{
        System.out.println("(6)");
    }
    _07_Son(){
//        super();  这一行代码在作为子类的类的构造器中不管写不写都会调用执行,调用父类中的构造器
        System.out.println("(7)");
    }
    {
        System.out.println("(8)");
    }
    @Override
    public int test(){
        System.out.println("(9)");
        return 1;
    }
    public static int method(){
        System.out.println("(10)");
        return 1;
    }

    public static void main(String[] args) {
        _07_Son son1 = new _07_Son();
        System.out.println("=================");
        _07_Son son2 = new _07_Son();
    }
}

class Father{

    /*
        非静态方法前面都有一个默认的对象this
        这里的this指向的就是那个实例,上面main方法中执行的是实例化son子类并且这里的test()方法被子类重写所以这里执行的是子类中重写的方法(面向对象的多态)
     */
    private int i = test();
    private static int j = method();
    static{
        System.out.println("(1)");
    }
    Father(){
        System.out.println("(2)");
    }
    {
        System.out.println("(3)");
    }
    public int test(){
        System.out.println("(4)");
        return 1;
    }
    public static int method(){
        System.out.println("(5)");
        return 1;
    }
}