package pers.mk.springcloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description: TODO
 * @Author: kun.ma
 * @Date: 2022/1/28 15:56
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
public class PaymentConsumer {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsumer.class,args);
    }
}
