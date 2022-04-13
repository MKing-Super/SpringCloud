package pers.mk.springcloud.payment.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@FeignClient(value = "SYS-SERVER")
public interface SysServiceFeignClient {

    @GetMapping("/sys/test")
    String test();


}
