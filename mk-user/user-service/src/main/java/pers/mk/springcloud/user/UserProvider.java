package pers.mk.springcloud.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: 提供者启动类
 * @Author: kun.ma
 * @Date: 2022/2/28 17:41
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class UserProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserProvider.class);

    public static void main(String[] args) {
        SpringApplication.run(UserProvider.class,args);
        LOGGER.info(">>>>>>>>>>>>>>>>>>>> UserProvider started~ >>>>>>>>>>>>>>>>>>>");
    }
}
