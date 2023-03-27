package stream;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author 刘佳俊
 *
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
 *  一, 创建Stream  集合流 数组流 无限流
 *
 *
 */
public class _01_Stream {
    /**
     * 创建流
     */
    
    public void test01(){
        /**
         * 集合流
         *  - Collection.stream() 串行流
         *  - Collection.parallelStream() 并行流
         */
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //数组流
        //Arrays.stream(array)
        String[] strings = new String[10];
        Stream<String> stream2 = Arrays.stream(strings);


        //Stream 静态方法
        //Stream.of(...)
        Stream<Integer> stream3 = Stream.of(1, 2, 3);

        //无限流 : 根据 将第一个参数作为其实值 再根据一定的逻辑 产生无限的数据 , 将这些无限的数据作为流 即 无限流


        // 无限流: 迭代
        Stream<Integer> stream4 = Stream.iterate(0, (i) -> ++i+i++);
        stream4.forEach(System.out::println);

        // 无限流: 生成
        Stream.generate(() -> Math.random())
                .limit(5)
                .forEach(System.out::println);
    }

}
