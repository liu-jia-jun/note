package com.config;

import com.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 刘佳俊
 */
@Configuration
@ComponentScan(value = "com")
public class SpringConfig {
    /**
     * 此处使用 @Bean注解，IOC容器获取的Bean的id值默认为该方法的方法名
     * name 属性相当于设置该Bean的id值
     */
    @Bean(name = "user")
    public User User(){
        return new User("林黛玉","777");
    }
}
