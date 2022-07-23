package com.test.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author L*2
 * @Date 2022/5/20 19:42
 * @Description：
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/nacos/{id}")
    public String getServerPort(@PathVariable("id") Integer id){
        return "端口号："+serverPort +"\t\n" +"id："+id;
    }
}
