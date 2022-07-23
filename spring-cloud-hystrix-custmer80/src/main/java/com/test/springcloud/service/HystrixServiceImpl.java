package com.test.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author L*2
 * @Date 2022/4/25 13:52
 * @Description：为避免代码的冗余，使用一个实现类实现服务降级和兜底方法
 */
@Component
public class HystrixServiceImpl implements FeignHystrixService{
    @Override
    public String payment_OK(Integer id) {
        return "这个ok方法已经挂了！";
    }

    @Override
    public String payment_TIMEOUT(Integer id) {
        return "这个超时方法已经挂了！";
    }
}
