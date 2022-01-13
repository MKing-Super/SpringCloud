package pers.mk.springcloud.payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import pers.mk.springcloud.payment.controller.PaymentController;

@SpringBootApplication
@EnableEurekaClient
public class PaymentConsumerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    public static void main(String[] args) {
        SpringApplication.run(PaymentConsumerApplication.class);
        LOGGER.info(">>>>>>>>>> PaymentConsumerApplication Started~ >>>>>>>>>>>");
    }
}
