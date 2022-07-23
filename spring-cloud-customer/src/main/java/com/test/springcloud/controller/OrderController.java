package com.test.springcloud.controller;


import com.test.springcloud.entities.CommentResult;
import com.test.springcloud.entities.Payment;
import com.test.springcloud.mylb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

//    private static final String PAYMENT_URL = "http://localhost:8001";

    private static final String PAYMENT_URL = "http://PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancer loadBalancer;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/customer/payment/add")
    public CommentResult<Payment> add(Payment payment){
       return restTemplate.postForObject(PAYMENT_URL+"/payment/add",payment,CommentResult.class);
    }

    @GetMapping("/customer/payment/getPayment/{id}")
    public CommentResult<Payment> getPayment(@PathVariable("id") int id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPayment/" +id,CommentResult.class);

    }

    /*
    使用该方法可以获取详细的信息
     */
    @GetMapping("/customer/payment/getForEntities/{id}")
    public CommentResult<Payment> getPayment2(@PathVariable("id") int id){
        ResponseEntity<CommentResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPayment/" + id, CommentResult.class);
        log.info("获取信息："+ forEntity.getStatusCode() +"----->" +forEntity.getHeaders() + "------>" +forEntity.getBody());
        if (forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else {
            return new CommentResult<>(444,"找不到记录！");
        }
    }


    /*
    自己配置的负载均衡：轮询
     */
    @GetMapping("/customer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

}
