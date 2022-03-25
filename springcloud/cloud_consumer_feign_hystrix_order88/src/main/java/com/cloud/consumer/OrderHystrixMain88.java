package com.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 刘佳俊
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix// 开启服务降级
public class OrderHystrixMain88 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain88.class, args);
    }
}
