package pers.mk.springcloud.payment.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pers.mk.springcloud.payment.controller.PaymentController;

@Configuration
public class ApplicationContextConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContextConfig.class);

    @Bean
    @LoadBalanced
    //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
