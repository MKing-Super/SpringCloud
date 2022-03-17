package pers.mk.springcloud.payment.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.mk.springcloud.payment.model.CommonResult;
import pers.mk.springcloud.payment.model.Order;
import pers.mk.springcloud.payment.model.Payment;
import pers.mk.springcloud.payment.model.PaymentAndOrder;
import pers.mk.springcloud.payment.wrapper.PaymentComplexWrapper;

import java.util.List;
import java.util.Map;

@Component
@RestController// @Controller + @ResponseBody
@FeignClient(value = "PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);

    @PostMapping("/payment/testpost")
    CommonResult<Payment> testpost(@RequestBody Payment payment);

    @GetMapping("/payment/two")
    CommonResult<Payment> two(@RequestParam("id") Integer id,@RequestParam("serial") String serial);

    @PostMapping("/payment/complex/two")
    CommonResult<String> complexTwo(@RequestBody Map<String,Object> map);

    @PostMapping("/payment/complex/two1000")
    CommonResult<String> complexTwo1000(@RequestBody Map<String,Object> map);

    @PostMapping("/payment/complex/two1001")
    CommonResult<PaymentAndOrder> complexTwo1001(@RequestBody PaymentAndOrder paymentAndOrder);

    @Deprecated
    @GetMapping("/payment/test")
    CommonResult<PaymentAndOrder> test(@RequestBody PaymentAndOrder paymentAndOrder);

    /**
     * 多对象入参
     * @Author  kun.ma
     * @Date    2022/3/2 16:15
     * @Param   [paymentComplexWrapper]
     * @Return  java.lang.String
     */
    @RequestMapping(value = "/payment/complex",method = RequestMethod.POST)
    String complex(@RequestBody PaymentComplexWrapper paymentComplexWrapper);


    @GetMapping("/payment/param/test")
    String paramTest(@RequestParam("payment") Payment payment, @RequestParam("order") Order order);

    @GetMapping("/payment/param/test0")
    Integer[] paramTest0(@RequestParam("dataIds") Integer[] dataIds);


    @GetMapping("/payment/param/test1")
    Integer[] paramTest1(@RequestParam("brand") String brand, @RequestParam("actId") Integer actId, @RequestParam("seriesIds") Integer[] seriesIds, @RequestParam("orgIds") Integer[] orgIds);

    @GetMapping("/payment/param/test2")
    Integer paramTest1(@RequestParam("brand") String brand, @RequestParam("actId") Integer actId);

    @PostMapping("/payment/param/test1")
    CommonResult<Payment> paramTest1(@RequestBody Payment payment);

    @PostMapping("/payment/param/test4")
    CommonResult<Payment> paramTest4(@RequestBody Payment payment,@RequestParam("str") String str);

    @PostMapping("/payment/param/test5")
    String paramTest5(@RequestBody Payment payment, @RequestParam("order") Order order);

    @PostMapping("/payment/param/test6")
    String paramTest6(@RequestBody List<Payment> list);

    @Deprecated
    @GetMapping("/payment/param/test7")
    String paramTest7(@RequestParam("list") List<Payment> list);

    @GetMapping("/payment/param/test8")
    String paramTest8(@RequestParam("list") List<Integer> list);

    @PostMapping("/payment/param/test9")
    String paramTest9(@RequestParam("id") Integer id,@RequestBody List<Payment> list);

    @PostMapping("/payment/param/test10")
    String paramTest10(@RequestBody Map<String,Object> map);

    @Deprecated
    @RequestMapping(value = "/payment/param/test11",method = RequestMethod.GET)
    String paramTest11(@RequestParam("map") Map<String,Object> map);

    @RequestMapping(value = "/payment/param/test12",method = RequestMethod.GET)
    String paramTest12(@RequestParam("arr") Payment[] arr);

    @RequestMapping(value = "/payment/param/test13",method = RequestMethod.POST)
    String paramTest13(@RequestBody Payment[] arr);

    @RequestMapping(value = "/payment/param/test14",method = RequestMethod.GET)
    String paramTest14(@RequestParam("list") List<Integer> list);

    @RequestMapping(value = "/payment/param/test15",method = RequestMethod.POST)
    String paramTest15(@RequestBody List<Integer> list);

    @RequestMapping(value = "/payment/param/test16",method = RequestMethod.POST)
    String paramTest16(@RequestParam("ll") Long ll,
                       @RequestParam("list") List<Integer> list,
                       @RequestParam("list0") List<String> list0,
                       @RequestBody Payment payment);



}
