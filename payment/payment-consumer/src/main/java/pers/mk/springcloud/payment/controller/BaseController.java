package pers.mk.springcloud.payment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.mk.springcloud.payment.model.Order;
import pers.mk.springcloud.payment.service.BaseService;

import javax.annotation.Resource;

/**
 * @Description: TODO
 * @Author: kun.ma
 * @Date: 2022/3/23 20:10
 */
@Controller
@RequestMapping("/base")
public class BaseController {
    @Resource
    private BaseService baseService;

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        String mkmk = baseService.baseMethod("mkmk");
        return mkmk;
    }


}
