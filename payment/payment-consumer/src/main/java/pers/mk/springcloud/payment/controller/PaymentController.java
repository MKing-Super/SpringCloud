package pers.mk.springcloud.payment.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.mk.springcloud.payment.model.CommonResult;
import pers.mk.springcloud.payment.model.Payment;
import pers.mk.springcloud.payment.service.OrderFeignService;
import pers.mk.springcloud.payment.service.PaymentFeignService;

import javax.annotation.Resource;

@Controller
public class PaymentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    @Resource
    private PaymentFeignService paymentFeignService;
    @Resource
    private OrderFeignService orderFeignService;


    @RequestMapping("/consumer")
    public String consumer(Model model){
        Long aLong = new Long(1);
        CommonResult<Payment> paymentById = paymentFeignService.getPaymentById(aLong);
        LOGGER.info(paymentById.toString());
        String timeout = orderFeignService.timeout();
        CommonResult testpost = paymentFeignService.testpost(new Payment(new Long(1), "666"));
        LOGGER.info(testpost.toString());
        CommonResult two = paymentFeignService.two(66, "mkmk12111");
        LOGGER.info(two.toString());
        model.addAttribute("paymentById",JSON.toJSONString(paymentById));
        model.addAttribute("timeout",timeout);
        return "/index";
    }
}
