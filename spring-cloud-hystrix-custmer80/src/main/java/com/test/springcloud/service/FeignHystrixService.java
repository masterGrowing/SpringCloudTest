package com.test.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author L*2
 * @Date 2022/4/25 10:10
 */
@Component
//使用fallback进行接口的实现类配置，保证没有代码得冗余，不用每个接口都写一个兜底方法和全局兜底方法配置
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT", fallback = HystrixServiceImpl.class)
public interface FeignHystrixService {
    @GetMapping("/payment/hystrix/payment_ok/{id}")
    public String payment_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/payment_out/{id}")
    public String payment_TIMEOUT(@PathVariable("id") Integer id);
}
