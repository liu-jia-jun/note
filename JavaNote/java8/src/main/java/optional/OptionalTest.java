package optional;


import stream.Employee;

import java.util.Optional;

/**
 * @author 刘佳俊
 *
 *
 * **定义：**Optional 类 (java.util.Optional) 是一个容器类，代表一个值存在或不存在，原来用 null 表示一个值不存在，现在用 Optional 可以更好的表达这个概念；并且可以避免空指针异常
 *
 * 常用方法：
 *
 * Optional.of(T t)：创建一个 Optional 实例
 * Optional.empty(T t)：创建一个空的 Optional 实例
 * Optional.ofNullable(T t)：若 t 不为 null，创建 Optional 实例，否则空实例
 * isPresent()：判断是否包含某值
 * orElse(T t)：如果调用对象包含值，返回该值，否则返回 t
 * orElseGet(Supplier s)：如果调用对象包含值，返回该值，否则返回 s 获取的值
 * map(Function f)：如果有值对其处理，并返回处理后的 Optional，否则返回 Optional.empty()
 * flatmap(Function mapper)：与 map 相似，要求返回值必须是 Optional
 *
 *
 *
 */
public class OptionalTest {

    
    public void test01() {
        Optional<Employee> op = Optional.of(new Employee());
        Employee employee = op.get();
    }

    
    public void test02() {
        Optional<Employee> op = Optional.empty();
        Employee employee = op.get();
    }

    
    public void test03() {
        Optional<Employee> op = Optional.ofNullable(new Employee());
        Employee employee = op.get();
    }

    
    public void test04() {
        Optional<Employee> op = Optional.ofNullable(new Employee());
        if (op.isPresent()) {
            Employee employee = op.get();
        }
    }


}
