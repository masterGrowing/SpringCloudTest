package com.test.springcloud.service;

import com.test.springcloud.entities.Payment;

public interface PaymentService {
    public int addPayment(Payment payment);

    public Payment getPayment(int id);
}
