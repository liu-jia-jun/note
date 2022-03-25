package com.cloud.consumer.service;

import org.springframework.stereotype.Component;

/**
 * @author 刘佳俊
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "来自paymentInfo_OK的错误";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "来自paymentInfo_TimeOut的错误";
    }
}
