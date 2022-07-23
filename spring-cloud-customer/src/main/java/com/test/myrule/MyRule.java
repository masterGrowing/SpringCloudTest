package com.test.myrule;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
切记改配置类不能在ComponentScan的包及其子包下
 */
@Configuration
public class MyRule {

    @Bean
    public IRule myRules(){
       return new RandomRule();   //随机的Rule，即选择的服务可以是1111，再222，而不是以前的1，2交替选择
    }
}
