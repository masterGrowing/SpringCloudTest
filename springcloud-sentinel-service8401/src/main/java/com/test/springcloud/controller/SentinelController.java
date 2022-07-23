package com.test.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.test.springcloud.entities.CommentResult;
import com.test.springcloud.entities.Payment;
import com.test.springcloud.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author L*2
 * @Date 2022/5/25 20:22
 * @Description：
 */
@RestController
public class SentinelController {



    @GetMapping("/sentinel/test1")
    //当配置blockHandler时须记住参数应该相同，如下面的参数里面有p1、p2,但是这里没有，就会找不到服务降级的页面
    @SentinelResource(value = "test1", blockHandler = "fall_back")
    public String test1(){
        return "1";
    }

    @GetMapping("/sentinel/test2")
    public String test2(){
        return "2";
    }

    @GetMapping("/sentinel/hotKey")
    @SentinelResource(value = "block_hotKey", blockHandler = "fall_back_method")
    public String fall_back(@RequestParam(value = "p1", required = false) String p1,
                            @RequestParam(value = "p2", required = false) String p2){
        return "ok" +
                "\t" +
                "fine!";
    }

    public String fall_back_method(String p1, String p2, BlockException exception){
        return "服务器出错啦~~~~~~~";
    }

    public String fall_back(BlockException e){
        return "not access!";
    }

    //使用blockHandlerClass自定义的全局兜底方法
    @GetMapping("/sentinel/fall_back")
    @SentinelResource(value = "fall_back", blockHandlerClass = {CustomerBlockHandler.class}, blockHandler = "blockException2")
    public CommentResult fall_Back(){
        return new CommentResult(2000,"success!!!!",new Payment(1,"31123"));
    }

}
