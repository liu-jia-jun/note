package com.cloud.consumer.controller;

import com.cloud.common.entities.CommonResult;
import com.cloud.common.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author 刘佳俊
 */
@RestController
@RequestMapping("/consumer/payment")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    private String address = "http://localhost:8001";


    @GetMapping("/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
       return restTemplate.getForObject(address+"/payment/"+id,CommonResult.class);
    }
    @PostMapping("/create")
    public CommonResult<Payment> create(Payment payment){
        System.out.println(payment);

        return  restTemplate.postForObject(address+"/payment/",payment,CommonResult.class);

    }
}
