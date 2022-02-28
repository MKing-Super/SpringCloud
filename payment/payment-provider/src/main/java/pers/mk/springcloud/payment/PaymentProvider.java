package pers.mk.springcloud.payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentProvider.class);

    public static void main(String[] args) {
        SpringApplication.run(PaymentProvider.class,args);
        LOGGER.info(">>>>>>>>>>>>>>>> PaymentProvider started~ >>>>>>>>>>>>>>>>");
    }

}
