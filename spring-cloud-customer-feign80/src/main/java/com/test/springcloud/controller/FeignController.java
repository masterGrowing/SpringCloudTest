package com.test.springcloud.controller;


import com.test.springcloud.entities.CommentResult;
import com.test.springcloud.entities.Payment;
import com.test.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FeignController {
    
    @Autowired
    private PaymentFeignService paymentFeignService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * feign自带负载均衡
     * @param id
     * @return
     */
    @GetMapping("/customer/payment/getPayment/{id}")
    public CommentResult<Payment> getPayment(@PathVariable("id") int id){
        CommentResult payment = paymentFeignService.getPayment(id);
        if (payment != null){
            log.info("查到数据：{}",payment);
            return new CommentResult<>(400,"查到数据:"+payment+"端口号："+serverPort);
        }else {
            return new CommentResult<>(444,"找不到记录");
        }
    }


    /*
    超时控制
     */
    @GetMapping(value = "/customer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //客户端一般的默认等待时间为1秒钟，由于前面设置的3秒钟，所以
        return paymentFeignService.paymentFeignTimeout();
    }
}
