package pers.mk.springcloud.payment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.mk.springcloud.payment.model.Order;
import pers.mk.springcloud.payment.service.OrderFeignService;

import javax.annotation.Resource;

/**
 * @Description: TODO
 * @Author: kun.ma
 * @Date: 2022/3/17 16:39
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderFeignService orderFeignService;

    @GetMapping("/timeout")
    @ResponseBody
    public String timeout(){
        String timeout = orderFeignService.timeout();
        return timeout;
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        Order order = new Order(1,"马坤","mima");
        String timeout = orderFeignService.test("6666" , order);
        return timeout;
    }










}
