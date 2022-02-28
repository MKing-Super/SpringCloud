package pers.mk.springcloud.payment.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.mk.springcloud.payment.service.OrderFeignService;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 订单实现类
 * @Author: kun.ma
 * @Date: 2022/2/28 16:56
 */
@Service
@RestController
public class OrderFeignServiceImpl implements OrderFeignService {


    @Override
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
