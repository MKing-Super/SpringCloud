package pers.mk.springcloud.payment.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pers.mk.springcloud.payment.model.Order;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description: 订单
 * @Author: kun.ma
 * @Date: 2022/2/28 16:17
 */
//@Component
//@Controller
//@ResponseBody
//@RestController
@FeignClient(value = "PAYMENT-SERVICE")
public interface OrderFeignService {

    @GetMapping("/orderService/timeout")
    String timeout();

    @RequestMapping("/orderService/test")
    String test(@RequestParam("str") String str, @RequestBody Order order);

    @RequestMapping("/orderService/test0")
    String test0(@RequestParam("str") String str);

    @RequestMapping("/orderService/test1")
    String test1(@RequestBody Order order);

    @RequestMapping("/orderService/test2")
    String test2(@RequestBody Order order,@RequestParam("str") String str);

    @RequestMapping("/orderService/test3")
    String test3(@RequestParam("str") String str,
                 @RequestParam("param") Integer param,
                 @RequestParam("list") List<String> list);

    @RequestMapping(value = "/orderService/test4",method = RequestMethod.POST)
    String test4(@RequestBody String str);

    @RequestMapping(value = "/orderService/test5")
    String test5(@RequestParam("bigDecimal") BigDecimal bigDecimal);

    @RequestMapping(value = "/orderService/test6")
    String test6(@RequestParam("date") Date date);

    @RequestMapping(value = "/orderService/test7")
    String test7(@RequestParam(value = "date",required = false) Date date);

    @Deprecated
    @RequestMapping(value = "/orderService/test8")
    String test8(@RequestParam(value = "date",required = true) Date date);


    @RequestMapping(value = "/orderService/test9")
    String test9(@RequestParam(value = "str0",required = false) String str0,
                 @RequestParam(value = "str1",required = false) String str1,
                 @RequestParam(value = "integer",required = false) Integer integer);

    @Deprecated
    @RequestMapping(value = "/orderService/test10")
    String test10(@RequestBody Order order);

    @Deprecated
    @RequestMapping(value = "/orderService/test11")
    String test11(@RequestBody(required = false) Order order);

    @RequestMapping(value = "/orderService/test12")
    String test12(@RequestBody Order order,
                  @RequestParam(value = "list",required = false) List<String> list);

    @RequestMapping(value = "/orderService/test13")
    String test13(@RequestBody List<String> list);

    @RequestMapping(value = "/orderService/test14")
    String test14(@RequestParam(value = "list",required = false) List<String> list);

    @RequestMapping(value = "/orderService/test15")
    String test15(@RequestBody List<String> list);

    @RequestMapping(value = "/orderService/test16")
    String test16(@RequestParam(value = "list",required = false) List<String> list);

    @RequestMapping(value = "/orderService/test17")
    String test17(@RequestParam(value = "list",required = false) List<String> list,
                  @RequestParam(value = "integerList",required = false) List<Integer> integerList);

    @RequestMapping(value = "/orderService/test18")
    String test18(@RequestBody List<String> list,
                  @RequestParam("str") String str,
                  @RequestParam("num") Integer num);




}
