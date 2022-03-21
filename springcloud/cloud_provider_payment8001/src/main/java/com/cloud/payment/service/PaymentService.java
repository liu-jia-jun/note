package com.cloud.payment.service;


import com.cloud.common.entities.Payment;

/**
 * @author 刘佳俊
 */

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
