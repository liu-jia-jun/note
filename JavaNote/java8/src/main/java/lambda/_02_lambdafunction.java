package lambda;




import java.util.ArrayList;

import java.util.List;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口
 *
 * 1. 我们可以定义一个函数式接口 MyFunction
 *      在该函数式接口中只有一个抽象方法
 *
 * 2. 我们可以使用 lambda 这个匿名内部类的写法 去实现这个接口 从而提供不同的操作
 *
 * 3. 这里就是简化了 匿名内部类的写法 同时也减少了 为了实现这个接口中的方法而创建的类
 *
 *
 */
public class _02_lambdafunction {

    /**
     * 这个测试用例主要是用来表明
     *
     * 我们可以通过 lambda 表达式 很轻松的去实现一个函数式接口中的方法
     * 从而简便开发 , 减少代码量 提供相对多的功能
     */
    
    public void test() {


        // 四行代码 实现了 四次这个MyFunction 接口 , 重写接口中的方法
        MyFunction fun1 = (x, y) -> x + y;
        MyFunction fun2 = (x, y) -> x - y;
        MyFunction fun3 = (x, y) -> x * y;
        MyFunction fun4 = (x, y) -> x / y;

        System.out.println("加法运算"+fun1.operation(6, 2));
        System.out.println("减法运算"+fun2.operation(6, 2));
        System.out.println("乘法运算"+fun3.operation(6, 2));
        System.out.println("除法运算"+fun4.operation(6, 2));

    }

    //+++++++++++++++++++++++++lambda 中内置的四大函数式接口+++++++++++++++++++++++++++++++++++++++


    // 1. 消费性函数式接口 Consoumer<T>
    // 2. 提供一个参数 , 在 lambda体中对这个参数做相应的操作 , 没有返回值

    
    public void test01(){

            // 提供一个参数 , 并且没有返回值
            Consumer<Integer> consumer = (x) -> System.out.println("消费型接口" + x);
            //test
            consumer.accept(100);
    }

    // 1. 提供型函数式接口 Supplier<T>
    // 2. 没有参数 , 但是需要提供返回值的类型 ,


    // 注意 : 在 lambda中  是可以通过context上下文来获取数据类型的 所以 在lambda表达式的 参数列表中是没有参数类型的 当然也可以写也可以不写

    
    public void test02(){
        List<Integer> list = new ArrayList<>();


        //Supplier<T>  返回一个 10以内的随机整数
        Supplier<Integer> supplier = () -> (int)(Math.random() * 10);
        for (int i = 0; i < 5; i++) {
            // supplier.get() 这个方法每次调用都会返回一个10以内的随机整数
            list.add(supplier.get());
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    // 1. 函数型函数式接口 Function<T, R>
    // 2. 对类型为T的对象应用操作，并返回结果为R类型的对象：R apply(T t)
    
    public void test03(){
        //Function<T, R>
        String oldStr = "abc123456xyz";
        Function<String, String> function = (s) -> s.substring(1, s.length()-1);
        //test
        System.out.println(function.apply(oldStr));
    }


    // 1. 断言型函数式接口 Predicate<T>
    // 2. 根据提供的指定的数据类型 的值 在内部进行逻辑判断  返回boolean类型
    
    public void test04(){
        //Predicate<T>
        Integer age = 35;
        Predicate<Integer> predicate = (i) -> i >= 35;

        if (predicate.test(age)){
            System.out.println("你该退休了");
        } else {
            System.out.println("我觉得还OK啦");
        }
    }

    //+++++++++++++++++++++++++++++++还有其他类型的接口 属于这四大类型接口 的子接口++++++++++++++++++++++++++++++++++++++++++++++++++++++++



}
