package pers.mk.springcloud.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.mk.springcloud.payment.model.CommonResult;
import pers.mk.springcloud.payment.model.Payment;
import pers.mk.springcloud.payment.service.PaymentFeignService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @RequestMapping(value = "/consumer/payment/get/{id}",method = {RequestMethod.GET})
    //占位符映射
    public CommonResult<Payment> getPaymentById(@PathVariable Long id){
        return paymentFeignService.getPaymentById(id);
    }


    @RequestMapping("/hello")
    public String test(){
        return "/payment/hello";
    }
}
