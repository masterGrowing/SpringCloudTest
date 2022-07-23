package com.test.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.test.springcloud.service.FeignHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author L*2
 * @Date 2022/4/25 10:14
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Hystrix_all")
public class CustomerHystrixController {
    @Autowired
    private FeignHystrixService feignHystrixService;

    @GetMapping("/customer/payment/hystrix/payment_ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id){
        String result = feignHystrixService.payment_OK(id);
        return result;
    }

    @GetMapping("/customer/payment/hystrix/payment_out/{id}")
//    @HystrixCommand(fallbackMethod = "payment_Hystrix_out",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "500")
//    })
    //使用全局的服务降级兜底方法，不使用特定的服务降级兜底方法
    @HystrixCommand
    public String payment_TIMEOUT(@PathVariable("id") Integer id){
        String result = feignHystrixService.payment_TIMEOUT(id);
        return result;
    }

    public String payment_Hystrix_out(){
        return "这是客户端80服务期繁忙，请稍后再试！";
    }

    //下面是全局fallback
    public String payment_Hystrix_all(){
        return "哦嚯！网络出错了哦！";
    }
}
