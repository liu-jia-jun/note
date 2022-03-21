package com.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 刘佳俊
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerMain88 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain88.class,args);
    }
}
