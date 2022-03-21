package com.cloud.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 刘佳俊
 */
@Configuration
public class SpringBootConfiguration {
    @Bean
    public RestTemplate restTemplate(){
        // 注入RestTemplate，可以调用其他服务
        return new RestTemplate();
    }
}
