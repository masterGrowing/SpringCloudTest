package com.test.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @Author L*2
 * @Date 2022/5/11 16:19
 * @Description：一个自定义的网关过滤器
 */
@Component
@Slf4j
public class GetWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("========================"+ new Date());
        //表示访问的地址必须是带着uName参数的，只要不带，则会报错
        String uName = exchange.getRequest().getQueryParams().getFirst("uName");
        if (uName == null){
            log.info("&&&&&&&&&&&&&&&&&,找不到高该用户噢~");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
