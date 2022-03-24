package com.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 刘佳俊
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZKMain88 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZKMain88.class, args);
    }
}