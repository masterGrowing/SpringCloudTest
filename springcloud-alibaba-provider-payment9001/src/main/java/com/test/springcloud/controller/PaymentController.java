package com.test.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author L*2
 * @Date 2022/5/20 19:29
 * @Description：
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @RequestMapping("/payment/nacos/{id}")
    public String getServerPort(@PathVariable("id") Integer id){
        return "使用Nacos启动，并且获取得到的端口号为："+serverPort+"\t"+"id"+id;
    }
}
