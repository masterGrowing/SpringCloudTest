package com.test.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author L*2
 * @Date 2022/5/19 12:52
 * @Description：
 */
@RestController
@RefreshScope
public class ClientConfigController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/getInfo")
    public String getInfos(){
        return "serverPort"+ serverPort + "=======information"+ configInfo;
    }
}
