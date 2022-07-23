package com.test.springcloud.controller;


import com.test.springcloud.entities.CommentResult;
import com.test.springcloud.entities.Payment;
import com.test.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/add")
    public CommentResult add(@RequestBody Payment payment){
        int i = paymentService.addPayment(payment);
        log.info("插入成功：{}",i);



        if (i > 0){

            return new CommentResult(200,"插入成功！+"+serverPort,i);
        }else {
            return new CommentResult(400,"插入失败！"+serverPort,null);
        }
    }

    @GetMapping("/payment/getPayment/{id}")
    public CommentResult getPayment(@PathVariable("id") int id){
        Payment payment = paymentService.getPayment(id);
        log.info("查到数据：{}",payment);

        if (payment != null){
            return new CommentResult(200,"查询成功！"+serverPort,payment);
        }else {
            return new CommentResult(400,"查询失败！"+serverPort,null);
        }
    }


    @GetMapping(value = "/payment/discovery")
    public Object getDiscovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service------>"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
                log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getServerPort(){
        return serverPort;
    }


    /**
     * 超时设置，feign默认只等待一秒钟
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
