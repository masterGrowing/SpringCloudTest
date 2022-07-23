package com.test.springcloud.service.impl;

import com.test.springcloud.service.MessageSendService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author L*2
 * @Date 2022/5/19 15:59
 * @Description：
 */
@EnableBinding(Source.class)    //定义消息的推送管道（相比较于消费者，是Sink.class）
public class MessageServiceImpl implements MessageSendService {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {

        String serial = UUID.randomUUID().toString();
        //固定使用MessageBuilder下面的build方法，消费者getPayLoad
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println(serial);
        return null;
    }
}
