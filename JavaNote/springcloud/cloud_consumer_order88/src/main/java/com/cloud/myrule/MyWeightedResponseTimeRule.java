package com.cloud.myrule;

import com.netflix.loadbalancer.IRule;


import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 刘佳俊
 * 对RoundRobinRule的扩展，响应速度越快的实例选择权重越大，越容易被选择
 */
@Configuration
public class MyWeightedResponseTimeRule {

    @Bean
    public IRule myRule()
    {
        return new WeightedResponseTimeRule();
    }
}
