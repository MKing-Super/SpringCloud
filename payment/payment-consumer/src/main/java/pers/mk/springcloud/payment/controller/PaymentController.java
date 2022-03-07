package pers.mk.springcloud.payment.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.mk.springcloud.payment.model.CommonResult;
import pers.mk.springcloud.payment.model.Order;
import pers.mk.springcloud.payment.model.Payment;
import pers.mk.springcloud.payment.model.PaymentAndOrder;
import pers.mk.springcloud.payment.service.OrderFeignService;
import pers.mk.springcloud.payment.service.PaymentFeignService;
import pers.mk.springcloud.payment.wrapper.PaymentComplexWrapper;

import javax.annotation.Resource;
import java.util.HashMap;

@Controller
public class PaymentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    @Resource
    private PaymentFeignService paymentFeignService;
    @Resource
    private OrderFeignService orderFeignService;


    @RequestMapping("/consumer")
    public String consumer(Model model){
        Long aLong = new Long(1);
        CommonResult<Payment> paymentById = paymentFeignService.getPaymentById(aLong);
        LOGGER.info(paymentById.toString());
        String timeout = orderFeignService.timeout();
        Payment payment = new Payment(new Long(1), "666");
        CommonResult testpost = paymentFeignService.testpost(payment);
        LOGGER.info(testpost.toString());
        CommonResult two = paymentFeignService.two(66, "mkmk12111");
        LOGGER.info(two.toString());
        Order order = new Order(4324, "superadmin", "123456");
        HashMap<String, Object> map = new HashMap<>();
        map.put("payment",payment);
        map.put("order",order);
        //使用map未入参，传递实例对象无法获取正常的值，get返回null不报错，post可以传入参（注意json转换问题）
        CommonResult<String> stringCommonResult = paymentFeignService.complexTwo(map);
        LOGGER.info(stringCommonResult.getData());
        //将map中的对象转成json字符串后再进行入参，get不行，post可以用~~~
        HashMap<String, Object> stringMap = new HashMap<>();
        stringMap.put("payment",JSON.toJSONString(payment));
        stringMap.put("order",JSON.toJSONString(order));
        CommonResult<String> stringCommonResult1 = paymentFeignService.complexTwo1000(stringMap);
        LOGGER.info(stringCommonResult1.getData());
        //使用payment和order综合类进行传参,post可以正确传参
        PaymentAndOrder paymentAndOrder = new PaymentAndOrder(payment, order);
        CommonResult<PaymentAndOrder> paymentAndOrderCommonResult = paymentFeignService.complexTwo1001(paymentAndOrder);
        LOGGER.info("----------->>>>" + paymentAndOrderCommonResult.getData().toString());

        model.addAttribute("paymentById",JSON.toJSONString(paymentById));
        model.addAttribute("timeout",timeout);
        return "/index";
    }

    @RequestMapping("/test")
    public String test(Model model){
        Payment payment = new Payment(new Long(1), "666");
        Order order = new Order(4324, "superadmin", "123456");
        PaymentAndOrder paymentAndOrder = new PaymentAndOrder(payment , order);
        CommonResult<PaymentAndOrder> paymentAndOrderCommonResult = paymentFeignService.complexTwo1001(paymentAndOrder);
        System.out.println(paymentAndOrderCommonResult);
        String s = JSON.toJSONString(paymentAndOrderCommonResult.getData());

        //getmapping 与 requestbody 入参为实例对象的时候，注解不能同时使用
//        CommonResult<PaymentAndOrder> test = paymentFeignService.test(paymentAndOrder);


        model.addAttribute("textarea",s);
        return "/index";
    }


    @RequestMapping(value = "/wrapper/complex",method = RequestMethod.GET)
    @ResponseBody
    public String wrapperComplex(){
        Payment payment = new Payment(new Long(1), "666");
        Order order = new Order(4324, "superadmin", "123456");
        PaymentComplexWrapper paymentComplexWrapper = new PaymentComplexWrapper(payment, order);
        String complex = paymentFeignService.complex(paymentComplexWrapper);
        return complex;
    }

    @RequestMapping(value = "/param/test",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest(){
        Payment payment = new Payment(new Long(1), "666");
        Order order = new Order(4324, "superadmin", "123456");
        String s = paymentFeignService.paramTest(payment, order);
        return s;
    }

    @RequestMapping(value = "/param/test0",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest0(){
        Integer data[] = {1, 2, 4, 545, 11, 32, 13131, 4444};
        Integer[] integers = paymentFeignService.paramTest0(data);
        String s = JSON.toJSONString(integers);
        return s;
    }

    @RequestMapping(value = "/param/test1",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest1(){
        Integer data[] = {1, 2, 4, 545, 11, 32, 13131, 4444};
        String str = "422423432";
        Integer[] integers = paymentFeignService.paramTest1(str,222,data,data);
        String s = JSON.toJSONString(integers);
        return s;
    }

    @RequestMapping(value = "/param/test2",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest2(){
        String str = "422423432";
        Integer integers = paymentFeignService.paramTest1(str,222);
        return integers.toString();
    }

    @RequestMapping(value = "/param/test3",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest3(){
        Payment payment = new Payment(new Long(1), "666");
        CommonResult testpost = paymentFeignService.paramTest1(payment);
        String s = testpost.getData().toString();
        return s;
    }

    @RequestMapping(value = "/param/test4",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest4(){
        Payment payment = new Payment(new Long(1), "666");
        CommonResult testpost = paymentFeignService.paramTest4(payment,"水水水水是是");
        String s = testpost.getData().toString();
        return s;
    }


    @RequestMapping(value = "/param/test5",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest5(){
        Payment payment = new Payment(new Long(1), "666");
        Order order = new Order(4324, "FSELFJSDALFJS", "123456");
        String s = paymentFeignService.paramTest5(payment, order);
        return s;
    }
}
