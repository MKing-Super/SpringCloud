package pers.mk.springcloud.payment.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.mk.springcloud.payment.model.CommonResult;
import pers.mk.springcloud.payment.model.Order;
import pers.mk.springcloud.payment.model.Payment;
import pers.mk.springcloud.payment.model.PaymentAndOrder;

import java.util.Map;

@Component
@RestController// @Controller + @ResponseBody
@FeignClient(value = "PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);

    @PostMapping("/payment/testpost")
    CommonResult<Payment> testpost(@RequestBody Payment payment);

    @GetMapping("/payment/two")
    CommonResult<Payment> two(@RequestParam("id") Integer id,@RequestParam("serial") String serial);

    @GetMapping("/payment/complex/two")
    CommonResult<String> complexTwo(@RequestParam Map<String,Object> map);

    @PostMapping("/payment/complex/two1000")
    CommonResult<String> complexTwo1000(@RequestBody Map<String,Object> map);

    @PostMapping("/payment/complex/two1001")
    CommonResult<PaymentAndOrder> complexTwo1001(@RequestBody PaymentAndOrder paymentAndOrder);
}
