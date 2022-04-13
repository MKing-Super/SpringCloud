package pers.mk.springcloud.payment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysController {

    @GetMapping("/sys/test")
    public String test(){
        return "这里是sys中的test方法~";
    }
}
