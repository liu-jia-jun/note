package com.cloud.consumer;

import com.cloud.myrule.MyRandomRule;
import com.cloud.myrule.MyWeightedResponseTimeRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author 刘佳俊
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration= MyRandomRule.class)
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration= MyWeightedResponseTimeRule.class)

/**
 * @RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration= MySelfRule.class)
 *
 * 该注解是设置eureka的负载均衡算法，
 *
 * 1. 通过在主启动类之外的myrule包下创建MySelfRule这个负载均衡算法的配置类，
 *
 * 2. 在主启动类上标明使用哪个默认算法即可
 *
 * 3. eureka默认的负载均衡算法为轮询

 */
public class ConsumerMain88 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain88.class,args);
    }
}
