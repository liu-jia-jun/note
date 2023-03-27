package stream;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 刘佳俊
 *
 * Stream 流是什么 : Stream 是数据渠道 , 用于操作数据源( 集合 , 数组 等) 所产生的元素序列
 *                  集合讲的是数据的存储 , 流讲的是数据的计算
 *
 *  注意:
 *          1. Stream 自身是不会存储元素的
 *          2. Stream 不会改变源对象 , 相反 , 他们会返回一个持有结果的新的Stream
 *          3. Stream 操作是延迟执行的 , 这意味着 Stream 会等到需要结果的时候才会执行
 *
 * Stream 的操作 有三个步骤
 *
 *  三, 终止操作
 *          在第一步中 将数据转化为流的形式 , 此时 我们可以对这个流里面的数据进行一系列的操作的
 */
public class _03_Stream {

    public enum Status {
        FREE, BUSY, VOCATION;
    }


    /*
        第一种: 查找匹配
            allMatch：检查是否匹配所有元素
            anyMatch：检查是否至少匹配一个元素
            noneMatch：检查是否没有匹配所有元素 即一个都不匹配
            findFirst：返回第一个元素
            findAny：返回当前流中的任意元素
            count：返回流中元素的总个数
            max：返回流中最大值
            min：返回流中最小值
     */

    
    public void test01(){
        List<Status> list = Arrays.asList(Status.FREE, Status.BUSY, Status.VOCATION);

        boolean flag1 = list.stream()
                .allMatch((s) -> s.equals(Status.BUSY));
        System.out.println(flag1);

        boolean flag2 = list.stream()
                .anyMatch((s) -> s.equals(Status.BUSY));
        System.out.println(flag2);

        boolean flag3 = list.stream()
                .noneMatch((s) -> s.equals(Status.BUSY));
        System.out.println(flag3);

        // 避免空指针异常
        Optional<Status> op1 = list.stream()
                .findFirst();
        // 如果Optional为空 找一个替代的对象
        Status s1 = op1.orElse(Status.BUSY);
        System.out.println(s1);

        Optional<Status> op2 = list.stream()
                .findAny();
        System.out.println(op2);

        long count = list.stream()
                .count();
        System.out.println(count);
    }


    /*
        第二种: 归约 / 收集
            归约：reduce(T identity, BinaryOperator) / reduce(BinaryOperator) 可以将流中的数据依次结合起来，得到一个值
            收集：collect 将流转换成其他形式；接收一个 Collector 接口的实现，用于给流中元素做汇总的方法
     */


    /**
     * Java：
     *  - reduce：需提供默认值（初始值）
     * Kotlin：
     *  - fold：不需要默认值（初始值）
     *  - reduce：需提供默认值（初始值）
     */
    
    public void test02(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer integer = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(integer);
    }

    List<Employee> emps = Arrays.asList(
            new Employee(101, "Z3", 19, 9999.99),
            new Employee(102, "L4", 20, 7777.77),
            new Employee(103, "W5", 35, 6666.66),
            new Employee(104, "Tom", 44, 1111.11),
            new Employee(105, "Jerry", 60, 4444.44)
    );

    
    public void test03(){
        //放入List
        List<String> list = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        //放入Set
        Set<String> set = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        //放入LinkedHashSet
        LinkedHashSet<String> linkedHashSet = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        linkedHashSet.forEach(System.out::println);
    }

    
    public void test04(){
        //总数
        Long count = emps.stream()
                .collect(Collectors.counting());
        System.out.println(count);

        //平均值
        Double avg = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);

        //总和
        Double sum = emps.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);

        //最大值
        Optional<Employee> max = emps.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(max.get());

        //最小值
        Optional<Double> min = emps.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());
    }

    
    public void test05(){
        //分组
        Map<Integer, List<Employee>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getId));
        System.out.println(map);

        //多级分组
        Map<Integer, Map<String, List<Employee>>> mapMap = emps.stream()
                .collect(Collectors.groupingBy(Employee::getId, Collectors.groupingBy((e) -> {
                    if (e.getAge() > 35) {
                        return "开除";
                    } else {
                        return "继续加班";
                    }
                })));
        System.out.println(mapMap);

        //分区
        Map<Boolean, List<Employee>> listMap = emps.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSalary() > 4321));
        System.out.println(listMap);
    }

    
    public void test06(){
        //总结
        DoubleSummaryStatistics dss = emps.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getMax());
        System.out.println(dss.getMin());
        System.out.println(dss.getSum());
        System.out.println(dss.getCount());
        System.out.println(dss.getAverage());

        //连接
        String str = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.joining("-")); //可传入分隔符
        System.out.println(str);
    }


}
