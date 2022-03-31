package pers.mk.springcloud.payment.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: TODO
 * @Author: kun.ma
 * @Date: 2022/3/23 19:58
 */
@FeignClient(value = "PAYMENT-SERVICE")
public interface BaseService {

    @GetMapping(value = "/baseMethod")
    String baseMethod(@RequestParam(value = "str",required = false) String str);
}
