package com.cloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 刘佳俊
 * 随机访问的负载均衡算法
 *
 * IRule是一个接口，该接口下有各种负载均衡算法具体的实现，我们可以直接将某个实现类直接注入到spring中即可
 */
@Configuration
public class MyRandomRule
{
    @Bean
    public IRule myRule()
    {
        return new RandomRule();//定义为随机
    }
}