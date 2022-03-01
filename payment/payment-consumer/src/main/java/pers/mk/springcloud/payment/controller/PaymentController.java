package pers.mk.springcloud.payment.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.mk.springcloud.payment.model.CommonResult;
import pers.mk.springcloud.payment.model.Order;
import pers.mk.springcloud.payment.model.Payment;
import pers.mk.springcloud.payment.model.PaymentAndOrder;
import pers.mk.springcloud.payment.service.OrderFeignService;
import pers.mk.springcloud.payment.service.PaymentFeignService;

import javax.annotation.Resource;
import java.util.HashMap;

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
        Payment payment = new Payment(new Long(1), "666");
        CommonResult testpost = paymentFeignService.testpost(payment);
        LOGGER.info(testpost.toString());
        CommonResult two = paymentFeignService.two(66, "mkmk12111");
        LOGGER.info(two.toString());
        Order order = new Order(4324, "superadmin", "123456");
        HashMap<String, Object> map = new HashMap<>();
        map.put("payment",payment);
        map.put("order",order);
        //使用map未入参，传递实例对象无法获取正常的值，get返回null不报错，post可以传入参（注意json转换问题）
        CommonResult<String> stringCommonResult = paymentFeignService.complexTwo(map);
        LOGGER.info(stringCommonResult.getData());
        //将map中的对象转成json字符串后再进行入参，get不行，post可以用~~~
        HashMap<String, Object> stringMap = new HashMap<>();
        stringMap.put("payment",JSON.toJSONString(payment));
        stringMap.put("order",JSON.toJSONString(order));
        CommonResult<String> stringCommonResult1 = paymentFeignService.complexTwo1000(stringMap);
        LOGGER.info(stringCommonResult1.getData());
        //使用payment和order综合类进行传参,post可以正确传参
        PaymentAndOrder paymentAndOrder = new PaymentAndOrder(payment, order);
        CommonResult<PaymentAndOrder> paymentAndOrderCommonResult = paymentFeignService.complexTwo1001(paymentAndOrder);
        LOGGER.info("----------->>>>" + paymentAndOrderCommonResult.getData().toString());

        model.addAttribute("paymentById",JSON.toJSONString(paymentById));
        model.addAttribute("timeout",timeout);
        return "/index";
    }
}
