package pers.mk.springcloud.payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import pers.mk.springcloud.payment.controller.PaymentController;

/**
 * @Description: 消费者
 * @Author: kun.ma
 * @Date: 2022/1/28 15:56
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
public class PaymentConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentConsumer.class);

    public static void main(String[] args) {
        SpringApplication.run(PaymentConsumer.class,args);
        LOGGER.info(">>>>>>>>>>>>> PaymentConsumer started~ >>>>>>>>>>>>>>");
    }
}
