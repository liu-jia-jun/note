package com.cloud.consumer.service;

import org.springframework.stereotype.Component;

/**
 * @author 刘佳俊
 */
@Component
/*
该类实现了PaymentHystrixService接口，表示对该接口做的服务降级
 */
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "来自paymentInfo_OK的错误";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "来自paymentInfo_TimeOut的错误";
    }
}
