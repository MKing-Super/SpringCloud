package pers.mk.springcloud.payment.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import pers.mk.springcloud.payment.service.BaseService;

/**
 * @Description: TODO
 * @Author: kun.ma
 * @Date: 2022/3/23 20:00
 */
@Service
@RestController
public class BaseServiceImpl implements BaseService {
    @Override
    public String baseMethod(String str) {
        return "这里是BaseService的实现类！" + str;
    }
}
