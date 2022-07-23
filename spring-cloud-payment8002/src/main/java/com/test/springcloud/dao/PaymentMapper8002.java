package com.test.springcloud.dao;


import com.test.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper8002 {
    public int addPayment(Payment payment);

    public Payment getPayment(@Param("id") int id);
}
