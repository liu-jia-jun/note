package com.cloud.sentinel.service;

import com.cloud.common.entities.CommonResult;
import com.cloud.common.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 刘佳俊
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)//调用中关闭9003服务提供者
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}