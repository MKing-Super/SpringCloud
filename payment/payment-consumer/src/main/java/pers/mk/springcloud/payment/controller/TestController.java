package pers.mk.springcloud.payment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

//    @RequestMapping("/hello")
//    public String test(){
//        return "/payment/hello";
//    }

    @RequestMapping("/consumer")
    public String consumer(){
        return "/payment/index";
    }
}
