package com.test.springcloud.service.Impl;


import com.test.springcloud.dao.PaymentMapper8001;
import com.test.springcloud.entities.Payment;
import com.test.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentImpl implements PaymentService {

    @Autowired
    private PaymentMapper8001 paymentMapper;

    @Override
    public int addPayment(Payment payment) {


        return paymentMapper.addPayment(payment);
    }

    @Override
    public Payment getPayment(int id) {
        return paymentMapper.getPayment(id);
    }
}
