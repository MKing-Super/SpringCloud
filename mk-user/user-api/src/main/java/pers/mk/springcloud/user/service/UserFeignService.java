package pers.mk.springcloud.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pers.mk.springcloud.user.model.CommonResult;

/**
 * @Description: 用户
 * @Author: kun.ma
 * @Date: 2022/2/28 17:40
 */
@Component
@RestController
@FeignClient(value = "PAYMENT-SERVICE")
public interface UserFeignService {
    @GetMapping("/user/get/{id}")
    CommonResult getUserById(@PathVariable("id")Integer id);
}
