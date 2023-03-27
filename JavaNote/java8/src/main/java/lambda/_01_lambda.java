package lambda;



import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Consumer;

/**
 * @author 刘佳俊
 *
 * lambda 初体验
 *
 *
 * lambda 是一个匿名函数 , 一种代码风格 替代 匿名函数的一种写法
 *
 *  基础语法:
      - 操作符：->
      - 左侧：参数列表
      - 右侧：执行代码块 / Lambda 体
 *
 *
 */

public class _01_lambda {

    /**
     * 使用匿名内部类的方式
     */

    public void test01() {
        //匿名内部类
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }


        };
        // 将比较器设置到TreeSet中用于排序
        TreeSet<Integer> set = new TreeSet<>(comparator);
    }

    /**
     * lambda 方式
     */

    public void test02() {
        // Lambda 表达式
        Comparator<Integer> comparator = (a, b) -> {
            return a - b;
        };

        // 将比较器设置到TreeSet中用于排序
        TreeSet<Integer> set = new TreeSet<>(comparator);
    }


    // ________________________lambda 练习_____________________________________



    public void practice01(){
        Consumer consumer = (x) -> System.out.println(x);
        consumer.accept("hello lambda");
    }



}
