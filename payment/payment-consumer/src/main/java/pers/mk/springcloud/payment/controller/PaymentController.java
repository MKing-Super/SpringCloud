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
import java.util.ArrayList;
import java.util.Date;
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

    @RequestMapping(value = "/param/test6",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest6(){
        ArrayList<Payment> list = new ArrayList<>();
        list.add(new Payment(new Long(1), "666"));
        list.add(new Payment(new Long(2), "sfs"));
        list.add(new Payment(new Long(333), "gdgggg"));
        String s = paymentFeignService.paramTest6(list);
        return s;
    }

    @RequestMapping(value = "/param/test7",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest7(){
        ArrayList<Payment> list = new ArrayList<>();
        list.add(new Payment(new Long(1), "666"));
        list.add(new Payment(new Long(2), "sfs"));
        list.add(new Payment(new Long(333), "gdgggg"));
        String s = paymentFeignService.paramTest7(list);
        return s;
    }

    @RequestMapping(value = "/param/test8",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest8(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(111);
        integers.add(22222);
        integers.add(113333331);
        String s = paymentFeignService.paramTest8(integers);
        return s;
    }

    @RequestMapping(value = "/param/test9",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest9(){
        ArrayList<Payment> list = new ArrayList<>();
        list.add(new Payment(new Long(1), "666"));
        list.add(new Payment(new Long(2), "sfs"));
        list.add(new Payment(new Long(333), "gdgggg"));
        String s = paymentFeignService.paramTest9(234,list);
        return s;
    }

    @RequestMapping(value = "/param/test10",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest10(){
        Payment payment = new Payment(new Long(1), "666");
        Order order = new Order(4324, "FSELFJSDALFJS", "123456");
        HashMap<String, Object> map = new HashMap<>();
        map.put("payment",payment);
        map.put("order",order);
        map.put("integer",5656777);
        String s = paymentFeignService.paramTest10(map);
        return s;
    }

    @RequestMapping(value = "/param/test11",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest11(){
        Payment payment = new Payment(new Long(1), "666");
        Order order = new Order(4324, "FSELFJSDALFJS", "123456");
        HashMap<String, Object> map = new HashMap<>();
        map.put("payment",payment);
        map.put("order",order);
        map.put("integer",5656777);
        String s = paymentFeignService.paramTest11(map);
        return s;
    }

    @RequestMapping(value = "/param/test12",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest12(){
        Payment[] arr = {
                new Payment(new Long(1), "666"),
                new Payment(new Long(1222), "fsdfasf"),
                new Payment(new Long(13333), "666eeee")
        };
        String s = paymentFeignService.paramTest12(arr);
        return s;
    }

    @RequestMapping(value = "/param/test13",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest13(){
        Payment[] arr = {
                new Payment(new Long(1), "666"),
                new Payment(new Long(1222), "fsdfasf"),
                new Payment(new Long(13333), "666eeee")
        };
        String s = paymentFeignService.paramTest13(arr);
        return s;
    }

    @RequestMapping(value = "/param/test14",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest14(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(222);
        list.add(4234);
        list.add(555);
        list.add(2266662);
        String s = paymentFeignService.paramTest14(list);
        return s;
    }

    @RequestMapping(value = "/param/test15",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest15(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(222);
        list.add(4234);
        list.add(555);
        list.add(2266662);
        String s = paymentFeignService.paramTest15(list);
        return s;
    }

    @RequestMapping(value = "/param/test16",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest16(){
        Payment payment = new Payment(new Long(1222), "fsdfasf");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(222);
        list.add(4234);
        list.add(555);
        list.add(2266662);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("sdgfsdfgsdf");
        strings.add("ss");
        strings.add("ggfgfg");
        Long aLong = new Long(666);
        String s = paymentFeignService.paramTest16(aLong,list,strings,payment);
        return s;
    }

    @RequestMapping(value = "/param/test17",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest17(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("aaaa",1);
        map.put("ssss",4324234);
        map.put("fffff",77777);
        String s = paymentFeignService.paramTest17(map);
        return s;
    }

    @RequestMapping(value = "/param/test18",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest18(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("aaaa",1);
        map.put("ssss",4324234);
        map.put("fffff",77777);
        String s = paymentFeignService.paramTest18(map);
        return s;
    }

    @RequestMapping(value = "/param/test19",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest19(){
        String s = paymentFeignService.paramTest19(new Date());
        return s;
    }

    @RequestMapping(value = "/param/test20",method = RequestMethod.GET)
    @ResponseBody
    public String paramTest20(){
        String s = paymentFeignService.paramTest20(new Date(),new Payment(new Long(1), "666"));
        return s;
    }









}
