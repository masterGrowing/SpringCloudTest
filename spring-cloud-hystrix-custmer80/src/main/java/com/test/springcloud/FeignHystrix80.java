package com.test.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author L*2
 * @Date 2022/4/25 10:08
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class FeignHystrix80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignHystrix80.class,args);
    }
}
