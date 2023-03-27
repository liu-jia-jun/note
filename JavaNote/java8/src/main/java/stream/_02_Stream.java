package stream;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
 *  二, 中间操作
 *          在第一步中 将数据转化为流的形式 , 此时 我们可以对这个流里面的数据进行一系列的操作的
 *
 *
 *
 */
public class _02_Stream {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "Z3", 19, 9999.99),
            new Employee(102, "L4", 20, 7777.77),
            new Employee(103, "W5", 35, 6666.66),
            new Employee(104, "Tom", 44, 1111.11),
            new Employee(105, "Jerry", 60, 4444.44)
    );


    //========================================第一种: 筛选与切片=========================================================
    /*
    中间操作：
        第一种: 筛选与切片
        filter：接收 Lambda ，从流中排除某些元素
        limit：截断流，使其元素不超过给定数量
        skip(n)：跳过元素，返回一个舍弃了前n个元素的流；若流中元素不足n个，则返回一个空流；与 limit(n) 互补
        distinct：筛选，通过流所生成的 hashCode() 与 equals() 取除重复元素

     */


    
    public void test01(){
        emps.stream()
                .filter((x) -> x.getAge() > 35)
                .limit(3) //短路？达到满足不再内部迭代  即 选出三个数据之后 不再迭代 直接返回
                .distinct()
                .skip(1)
                .forEach(System.out::println);

    }
    //========================================第二种: 映射=========================================================

    /*
    第二种: 映射
        map：接收 Lambda ，将元素转换为其他形式或提取信息；接受一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
        flatMap：接收一个函数作为参数，将流中每一个值都换成另一个流，然后把所有流重新连接成一个流
     */



    // map : 根据map中的函数逻辑将 流中的所有元素都按这套操作走一遍并得到一个新的元素
    
    public void test02(){
        List<String> list = Arrays.asList("a", "b", "c");

        // 如果这个链式操作的最后没有输出的话 那么返回的 是一个 Stream<String> 流
        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);
    }


    public Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }

        return list.stream();
    }

    /**
     * flatMap 与 map 的区别就是 :
     *              flatMap 返回的是一个流 ,这个流里面是不包含其他的流的 因为 flatMap 是将 各个流中的所有元素拿出来并添加到一个新的流中
     *              Map 返回的也是一个流 , 但这个流中可能存在其他的流 嵌套在里面
     */
    
    public void test03(){
        List<String> list = Arrays.asList("a", "b", "c");
        _02_Stream test02 = new _02_Stream();
        list.stream()
                .flatMap(test02::filterCharacter)
                .forEach(System.out::println);

        // 这个就是两者之间的区别 , 返回的类型不同 , 数据的存储形式不同
        Stream<Stream<Character>> streamStream = list.stream().map(test02::filterCharacter);
        Stream<Character> characterStream = list.stream().flatMap(test02::filterCharacter);

    }
//========================================第三种: 排序=========================================================


    /*
        sorted()：自然排序
        sorted(Comparator c)：定制排序  定制自己的排序规则 一般由于对象类型的数据
     */

    
    public void test04(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream()
                .sorted() //comparaTo()
                .forEach(System.out::println);
    }

    
    public void test05(){
        emps.stream()
                .sorted((e1, e2) -> { //compara()
                    // 先根 年龄排序 如果年龄相等就根据名字排序
                    if (e1.getAge()==(e2.getAge())){
                        return e1.getName().compareTo(e2.getName());
                    } else {
                        return e1.getAge()-(e2.getAge());
                    }
                })
                .forEach(System.out::println);
    }


}
