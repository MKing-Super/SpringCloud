package pers.mk.springcloud.payment.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import pers.mk.springcloud.payment.service.BaseService;

/**
 * @Description: TODO
 * @Author: kun.ma
 * @Date: 2022/3/23 20:08
 */
public class BigSonServiceImpl extends BaseServiceImpl implements BaseService {
    @Override
    public String baseMethod(String str) {
        return super.baseMethod(str) + "这里是BigSon！";
    }
}
