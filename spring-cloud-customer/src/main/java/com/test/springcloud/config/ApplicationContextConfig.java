package com.test.springcloud.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {


    /*
    使用RestTemplate方法获取webClint，调用其他接口
     */
    @Bean
    //赋予RestTemplate负载均衡能力，不然会出现nested exception is java.net.UnknownHostException: PAYMENT-SERVICE异常，即不知道是那台机器下的服务
//    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
