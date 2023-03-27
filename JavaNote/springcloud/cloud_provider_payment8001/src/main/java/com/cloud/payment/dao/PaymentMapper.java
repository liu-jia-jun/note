package com.cloud.payment.dao;


import com.cloud.common.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 刘佳俊
 *
 * @Mapper 与 @MapperScan 的区别
 * 1.
 *
 */
@Mapper
public interface PaymentMapper {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);

}
