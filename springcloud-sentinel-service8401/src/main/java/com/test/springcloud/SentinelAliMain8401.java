package com.test.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author L*2
 * @Date 2022/5/25 20:18
 * @Description：
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelAliMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelAliMain8401.class, args);
    }
}
