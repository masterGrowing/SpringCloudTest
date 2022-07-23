package com.test.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author L*2
 * @Date 2022/5/20 19:58
 * @Description：
 */
@RestController
public class ConsumerController {

    @Value("${service-url.nacos-user-service}")
    private String SERVICE_URL;

    @Autowired
    private RestTemplate restTemplate;


    //负载均衡
    @RequestMapping("/consumer/payment/nacos/{id}")
    public String getInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(SERVICE_URL+"/payment/nacos/"+id, String.class);
    }

}
