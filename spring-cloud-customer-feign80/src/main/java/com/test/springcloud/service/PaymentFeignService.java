package com.test.springcloud.service;


import com.test.springcloud.entities.CommentResult;
import com.test.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/getPayment/{id}")
    public CommentResult getPayment(@PathVariable("id") int id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
