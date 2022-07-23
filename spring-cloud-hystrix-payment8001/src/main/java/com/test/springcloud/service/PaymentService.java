package com.test.springcloud.service;

/**
 * @Author L*2
 * @Date 2022/4/24 17:59
 */
public interface PaymentService {
    public String payment_OK(Integer id);

    public String payment_TIMEOUT(Integer id);
}
