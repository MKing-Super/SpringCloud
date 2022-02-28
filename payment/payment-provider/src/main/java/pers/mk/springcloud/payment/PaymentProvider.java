package pers.mk.springcloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: TODO
 * @Author: kun.ma
 * @Date: 2022/1/28 15:42
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentProvider {

    public static void main(String[] args) {
        SpringApplication.run(PaymentProvider.class,args);
    }

}
