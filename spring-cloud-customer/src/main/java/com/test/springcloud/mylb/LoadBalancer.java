package com.test.springcloud.mylb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 重写负载平衡中的轮询方法
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
