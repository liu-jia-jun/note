package springtest;

import com.bean.Person;
import com.bean.User;
import com.config.SpringConfig;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 刘佳俊
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/bean.xml")
public class SpringTest {


    private String path = "bean.xml";

    @Test
    public void test(){
        System.out.println("hello");
    }

    /*

     */
    @Test
    public void beanTest1(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
        User user1 = (User) applicationContext.getBean("user1");
        User user2 = applicationContext.getBean("user2", User.class);

        System.out.println(user1);
        System.out.println(user2);
    }

    @Test
    public void beanTest2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
        Person person2 = (Person) applicationContext.getBean("person2");
        System.out.println(person2);
    }

    /**
     * 完全基于注解开发，编写spring的配置类
     */
    @Test
    public void beanTest3(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
    }

}
