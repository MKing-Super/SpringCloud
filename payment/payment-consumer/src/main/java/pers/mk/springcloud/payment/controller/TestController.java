package pers.mk.springcloud.payment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.mk.springcloud.payment.model.CommonResult;
import pers.mk.springcloud.payment.model.Payment;
import pers.mk.springcloud.payment.service.PaymentFeignService;

import javax.annotation.Resource;

@Controller
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Resource
    private PaymentFeignService paymentFeignService;
    @Autowired
    private OrderFeignController orderFeignController;

//    @RequestMapping("/hello")
//    public String test(){
//        return "/payment/hello";
//    }

    @RequestMapping("/consumer")
    public String consumer(){
        Long aLong = new Long(1);
        CommonResult<Payment> paymentById = paymentFeignService.getPaymentById(aLong);
        System.out.println(paymentById);
        CommonResult<Payment> paymentById1 = orderFeignController.getPaymentById(aLong);
        System.out.println(paymentById1);
        return "/index";
    }
}
