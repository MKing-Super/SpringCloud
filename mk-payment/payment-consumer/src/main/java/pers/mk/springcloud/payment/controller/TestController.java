package pers.mk.springcloud.payment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/hello")
    public String test(){
        return "hello";
    }

    @RequestMapping("/consumer")
    public String consumer(){
        return "/payment/index";
    }
}
