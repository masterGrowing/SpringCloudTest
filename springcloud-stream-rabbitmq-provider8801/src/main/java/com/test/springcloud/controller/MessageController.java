package com.test.springcloud.controller;

import com.test.springcloud.service.impl.MessageServiceImpl;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author L*2
 * @Date 2022/5/19 16:06
 * @Description：
 */
@RestController
public class MessageController {

    @Resource
    private MessageServiceImpl messageService;

    @RequestMapping("/sendMessage")
    public String messageSend(){
        return messageService.send();
    }
}
