package com.test.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author L*2
 * @Date 2022/5/20 19:41
 * @Description：
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentAliMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentAliMain9002.class, args);
    }
}
