package com.test.springcloud;


import com.test.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "PAYMENT-SERVICE",configuration = MyRule.class)
public class CustomerApplicationMain80 {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplicationMain80.class,args);
    }
}
