package com.test.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author L*2
 * @Date 2022/5/19 12:50
 * @Description：
 */
@SpringBootApplication
@EnableEurekaClient
public class ClientConfig3366 {
    public static void main(String[] args) {
        SpringApplication.run(ClientConfig3366.class, args);
    }
}
