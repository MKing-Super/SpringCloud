package pers.mk.springcloud.payment.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pers.mk.springcloud.payment.common.CommonResult;
import pers.mk.springcloud.payment.model.Payment;

/**
 * @Description: openfeign学习
 * @Author: kun.ma
 * @Date: 2022/1/27 10:31
 */
@Component
@FeignClient(value = "PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
