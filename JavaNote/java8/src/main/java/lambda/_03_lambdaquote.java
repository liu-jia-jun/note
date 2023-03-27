package lambda;


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author 刘佳俊
 *
 *
 * 引用
 *
 *  方法引用:
 *
 * 定义: 若 Lambda 表达式体中的内容已有方法实现，则我们可以使用“方法引用”
 *
 * 语法格式：
 *      对象 :: 实例方法
 *      类 :: 静态方法
 *      类 :: 实例方法
 *
 *
 */
public class _03_lambdaquote {


    //=================================方法引用===============================================================

    // 对象::实例方法
    // 注意: Lambda 表达实体中调用方法的参数列表、返回类型必须和函数式接口中抽象方法保持一致
    
    public void test01() {
        PrintStream ps = System.out;
        Consumer<String> con1 = (s) -> ps.println(s);
        con1.accept("aaa");

        // ps.println(x);
        Consumer<String> con2 = ps::println;
        con2.accept("bbb");
    }

    // 类::静态方法
    
    public void test02() {
        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);
        System.out.println(com1.compare(1, 2));

        // Integer.compare(x,y)
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(2, 1));
    }

    // 类::实例方法
    // 注意:Lambda 参数列表中的第一个参数是方法的调用者，第二个参数是方法的参数时，才能使用 ClassName :: Method
    
    public void test03() {
        BiPredicate<String, String> bp1 = (x, y) -> x.equals(y);
        System.out.println(bp1.test("a", "b"));

        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp2.test("c", "c"));
    }

    //=================================构造器引用===============================================================

    // 注意:需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致
    
    public void test04() {
        //================无参构造=========================
        Supplier<List> sup1 = () -> new ArrayList();
        List list = sup1.get();


        Supplier<List> sup2 = ArrayList::new;
        List list2 = sup2.get();

        // ================有参构造============================
        Function<Integer, List> function = (n) -> new ArrayList(n);
        List list3 = function.apply(10);

        // 默认找到 参数列表与 Function<Integer,List>对应的构造器 注意这里的参数列表只有Integer List是返回值
        Function<Integer, List> function1 = ArrayList::new;
        List list4 = function1.apply(10);





    }
    //=======================数组引用=========================
    
    public void test05(){
        Function<Integer,String[]> fun = (x)-> new String[x];
        String[] strings = fun.apply(10);

        Function<Integer,String[]> fun2 = String[]::new;
        String[] strings2 = fun2.apply(10);
    }

}
