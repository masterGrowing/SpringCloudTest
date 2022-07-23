package com.test.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.test.springcloud.service.Impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author L*2
 * @Date 2022/4/24 18:05
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentServiceImpl paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/payment_ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id){
        String result = paymentService.payment_OK(id);
        log.info("==========="+result);
        return result;
    }

    @GetMapping("/payment/hystrix/payment_out/{id}")
    @HystrixCommand(fallbackMethod = "payment_Hystrix_out",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String payment_TIMEOUT(@PathVariable("id") Integer id){
        String result = paymentService.payment_TIMEOUT(id);
        log.info("*************"+result);
        return result;
    }

    //这是服务降级后的兜底方案
    public String payment_Hystrix_out(Integer id){
        return "线程池： "+Thread.currentThread().getName() + " 系统繁忙，请稍后再试！,id： " + id +"\t" +"超时了，这是服务降级";
    }

    //服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String payment_CircuitBreaker_ok(@PathVariable("id") Integer id){
        String result = paymentService.payment_CircuitBreaker(id);
        return result;
    }
}
