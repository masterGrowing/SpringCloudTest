package com.test.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author L*2
 * @Date 2022/5/19 11:21
 * @Description：
 */
@RestController
@RefreshScope
public class ClientConfigController {

    //这里的config.info是读取的github上的config下的info信息
    @Value("${config.info}")
    private String clientInfo;

    @RequestMapping("/configInfo")
    public String getClientInfo(){
        return clientInfo;
    }
}
