package com.cloud.payment.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 刘佳俊
 */
@Service
public class PaymentService {

    // 正常方法
    public String paymentInfo_ok(String id) {
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_ok,id:   " + id;
    }

    // 延迟一定时间再返回

    /**
     * 超时访问，演示降级
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(String id) {
        int timeNumber = 6;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_ok,id:   " + id + "   耗时： " + timeNumber + "秒";
    }
    public String paymentInfo_TimeOutHandler(String id){
        return "/(ㄒoㄒ)/调用支付接口超时或异常：\t"+ "\t当前线程池名字" + Thread.currentThread().getName();
    }




    //=========服务熔断
    @HystrixCommand(fallbackMethod="fallbackBreakerTest",commandProperties={
            @HystrixProperty(name="circuitBreaker.enabled",value="true"), // 开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"), // 窗口期内的请求总次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="1000"), // 时间休眠窗
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60") // 失败率到达这个指标都开启断路器
            // 解释:在1000毫秒内,如果请求总数超过10次,且失败率达到百分之60以上,则开启断路器
    })
    public String paymentCircuitBreaker(Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String fallbackBreakerTest(Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }







}
