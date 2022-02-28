package pers.mk.springcloud.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @Author: kun.ma
 * @Date: 2022/2/28 16:23
 */
@RestController
@Slf4j
public class OrderController {
    @GetMapping("/order/timeout")
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "成功";
    }
}
