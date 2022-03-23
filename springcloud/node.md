# node

### 1.@Mapper与@MapperScan

#### @Mapper注解

**作用**：在接口类上添加了@Mapper，在编译之后会生成相应的接口实现类。

添加位置：接口类上面

```java
@Mapper
public interface UserMapper {
//代码
}

```
如果想要每个接口都要变成实现类，那么需要在每个接口类上加上@Mapper注解，比较麻烦，解决这个问题用@MapperScan。

#### @MapperScan注解

**作用**：指定要变成实现类的接口所在的包，然后包下面的所有接口在编译之后都会生成相应的实现类
添加位置：是在SpringBoot启动类上面添加

```java
@SpringBootApplication
@MapperScan("com.example.com.cloud.payment.dao")
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}

```
添加@MapperScan(“com.example.com.cloud.payment.dao”)注解以后，com.example.dao包下面的接口类，在编译之后都会生成相应的实现类。

使用@MapperScan注解多个包
```java
@MapperScan({"com.example.com.cloud.payment.dao","com.example.mapper"})

@SpringBootApplication  
@MapperScan({"com.example.com.cloud.payment.dao","com.example.mapper"})  
public class SpringbootApplication {  
public static void main(String[] args) {  
SpringApplication.run(SpringbootApplication.class, args);  
}  
}

```
**注意：因为@Mapper与MapperScan均为产生mapper接口的实现类所以推荐正确使用，最好不要一起使用不然会出现错误**

**注意：springcloud启动微服务时，不支持下划线，需要使用横线，即命名时使用横线代替下划线**

### consul
1. 在consul的目录下用cmd形式打开 
2. consul agent -dev 启动consul 
3. localhost:8500 是consul默认的ui界面