package com.test.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author L*2
 * @Date 2022/5/19 15:56
 * @Description：
 */
@SpringBootApplication
public class StreamRabbitmqProvider8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitmqProvider8801.class, args);
    }
}
