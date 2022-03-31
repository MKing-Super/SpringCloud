package pers.mk.springcloud.payment.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.mk.springcloud.payment.model.Order;
import pers.mk.springcloud.payment.service.OrderFeignService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "成功";
    }

    @Override
    public String test(String str, Order order) {
        String s = order.toString();
        System.out.println(s + str);
        return s + str;
    }

    @Override
    public String test0(String str) {
        return str;
    }

    @Override
    public String test1(Order order) {
        return order.toString();
    }


    @Override
    public String test2(Order order, String str) {
        return order.toString() + str;
    }

    @Override
    public String test3(String str, Integer param, @RequestParam("list") List<String> list) {
        return str + param + list.toString();
    }

    @Override
    public String test4(String str) {
        return str;
    }

    @Override
    public String test5(BigDecimal bigDecimal) {
        return bigDecimal.toString();
    }

    @Override
    public String test6(Date date) {
        return date.toString();
    }

    @Override
    public String test7(Date date) {
        if (date == null){
            return null;
        }else {
            return date.toString();
        }
    }

    @Override
    public String test8(Date date) {
        if (date == null){
            return null;
        }else {
            return date.toString();
        }
    }

    @Override
    public String test9(String str0, String str1, Integer integer) {
        return str0 + str1 + integer;
    }

    @Override
    public String test10(Order order) {
        if (order == null){
            return null;
        }else {
            return order.toString();
        }
    }

    @Override
    public String test11(Order order) {
        if (order == null){
            return null;
        }else {
            return order.toString();
        }
    }

    @Override
    public String test12(Order order, List<String> list) {
        String s = list.toString();
        String s1 = order.toString();

        return s + s1;
    }

    @Override
    public String test13(List<String> list) {
        return list.toString();
    }

    @Override
    public String test14(@RequestParam(value = "list",required = false) List<String> list) {
        return list.toString();
    }

    @Override
    public String test15(@RequestBody List<String> list) {
        return list.toString();
    }

    @Override
    public String test16(@RequestParam(value = "list",required = false) List<String> list) {
        return list.toString();
    }

    @Override
    public String test17(@RequestParam(value = "list",required = false) List<String> list,
                         @RequestParam(value = "integerList",required = false) List<Integer> integerList) {
        return list.toString() + integerList.toString();
    }

    @Override
    public String test18(@RequestBody List<String> list,
                         String str,
                         Integer num) {
        return list.toString() + str + num;
    }
}
