package com.test.springcloud.controller;


import com.test.springcloud.entities.CommentResult;
import com.test.springcloud.entities.Payment;
import com.test.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

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

    @GetMapping(value = "/payment/lb")
    public String getServerPort(){
        return serverPort;
    }
}
