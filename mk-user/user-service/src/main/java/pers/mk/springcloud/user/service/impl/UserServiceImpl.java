package pers.mk.springcloud.user.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pers.mk.springcloud.user.model.CommonResult;
import pers.mk.springcloud.user.service.UserFeignService;

/**
 * @Description: 用户实现类
 * @Author: kun.ma
 * @Date: 2022/2/28 17:45
 */
@Service
@RestController
public class UserServiceImpl implements UserFeignService {
    @Override
    @GetMapping("/user/get/{id}")
    public CommonResult getUserById(@PathVariable("id") Integer id) {
        CommonResult<String> commonResult = new CommonResult<>(200, "user查询正常", "mkmk");
        return commonResult;
    }
}
