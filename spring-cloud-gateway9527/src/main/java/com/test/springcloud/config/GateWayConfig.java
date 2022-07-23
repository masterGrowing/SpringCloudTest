package com.test.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author L*2
 * @Date 2022/5/10 22:02
 * @Description：
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder  routers = routeLocatorBuilder.routes();
        routers.route("path_route_test",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routers.build();
    }
}
