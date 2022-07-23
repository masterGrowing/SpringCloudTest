package com.test.springcloud.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import com.test.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author L*2
 * @Date 2022/4/24 18:02
 * @Dexcription:服务降级
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String payment_OK(Integer id) {
        return "线程池： "+Thread.currentThread().getName() + " ok,id： " + id +"\t" +"成了";
    }

    @Override
    public String payment_TIMEOUT(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(1);
        //这里证明不论是超时控制还是程序出现异常，都会触发服务降级
//            int age= 10/0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： "+Thread.currentThread().getName() + " out,id： " + id +"\t" +"成了个屁";
    }


    /**
     * 服务熔断
     */
    @HystrixCommand(fallbackMethod = "payment_Fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率达到多少后跳闸
    })
    public String payment_CircuitBreaker(Integer id){
        if (id < 0){
            throw new RuntimeException("id错误！");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "========" + uuid;
    }

    public String payment_Fallback(Integer id){
        return "服务器错误！";
    }
}
