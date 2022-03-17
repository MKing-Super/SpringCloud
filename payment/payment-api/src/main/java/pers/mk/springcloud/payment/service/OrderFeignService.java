package pers.mk.springcloud.payment.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.mk.springcloud.payment.model.Order;

/**
 * @Description: 订单
 * @Author: kun.ma
 * @Date: 2022/2/28 16:17
 */
//@Component
//@Controller
//@ResponseBody
//@RestController
@FeignClient(value = "PAYMENT-SERVICE")
public interface OrderFeignService {

    @GetMapping("/orderService/timeout")
    String timeout();

    @RequestMapping("/orderService/test")
    String test(@RequestParam("str") String str, @RequestBody Order order);




}
