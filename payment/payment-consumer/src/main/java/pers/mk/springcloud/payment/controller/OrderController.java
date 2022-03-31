package pers.mk.springcloud.payment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.mk.springcloud.payment.model.Order;
import pers.mk.springcloud.payment.service.OrderFeignService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/**
 * @Description: TODO
 * @Author: kun.ma
 * @Date: 2022/3/17 16:39
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderFeignService orderFeignService;

    @GetMapping("/timeout")
    @ResponseBody
    public String timeout(){
        String timeout = orderFeignService.timeout();
        return timeout;
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        Order order = new Order(1,"马坤","mima");
        String timeout = orderFeignService.test("6666" , order);
        return timeout;
    }

    @GetMapping("/test0")
    @ResponseBody
    public String test0(){
        String timeout = orderFeignService.test0("6666");
        return timeout;
    }

    @GetMapping("/test1")
    @ResponseBody
    public String test1(){
        Order order = new Order(1232,"马坤","123456");
        String str = orderFeignService.test1(order);
        return str;
    }

    @GetMapping("/test2")
    @ResponseBody
    public String test2(){
        Order order = new Order(1232,"马坤","123456");
        String str = "这是密码吗？";
        String result = orderFeignService.test2(order,str);
        return result;
    }

    @GetMapping("/test3")
    @ResponseBody
    public String test3(){
        String str = "这是密码吗？";
        Integer param = 2222;
        LinkedList<String> list = new LinkedList<>();
        list.add("afdsafsssss");
        list.add("wwwwwwwwwwwwwwwwwwwwwwww");
        String result = orderFeignService.test3(str,param,list);
        return result;
    }

    @GetMapping("/test4")
    @ResponseBody
    public String test4(){
        String str = "这是密码吗？";
        String result = orderFeignService.test4(str);
        return result;
    }

    @GetMapping("/test5")
    @ResponseBody
    public String test5(){
        BigDecimal bigDecimal = new BigDecimal("44.321");
        String result = orderFeignService.test5(bigDecimal);
        return result;
    }

    @GetMapping("/test6")
    @ResponseBody
    public String test6(){
        String result = orderFeignService.test6(new Date());
        return result;
    }

    @GetMapping("/test7")
    @ResponseBody
    public String test7(){
        Date date = null;
        String result = orderFeignService.test7(date);
        if (result == null){
            return "返回了null";
        }else {
            return result;
        }
    }

    @GetMapping("/test8")
    @ResponseBody
    public String test8(){
        Date date = null;
        String result = orderFeignService.test8(date);
        if (result == null){
            return "返回了null";
        }else {
            return result;
        }
    }

    @GetMapping("/test9")
    @ResponseBody
    public String test9(){
        String result = orderFeignService.test9("666","mkmk",9090);
        if (result == null){
            return "返回了null";
        }else {
            return result;
        }
    }

    @GetMapping("/test10")
    @ResponseBody
    public String test10(){
        String result = orderFeignService.test10(null);
        if (result == null){
            return "返回了null";
        }else {
            return result;
        }
    }

    @GetMapping("/test11")
    @ResponseBody
    public String test11(){
        String result = orderFeignService.test11(null);
        if (result == null){
            return "返回了null";
        }else {
            return result;
        }
    }

    @GetMapping("/test12")
    @ResponseBody
    public String test12(){
        Order order = new Order(666, "马坤", "uiojns");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("111");
        linkedList.add("222");
        linkedList.add("333");
        String s0 = orderFeignService.test12(order, linkedList);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("111");
        arrayList.add("222");
        arrayList.add("333");
        String s1 = orderFeignService.test12(order, arrayList);

        Vector<String> vector = new Vector<>();
        vector.add("111");
        vector.add("222");
        vector.add("333");
        String s2 = orderFeignService.test12(order, vector);

        Stack<String> stack = new Stack<>();
        stack.add("111");
        stack.add("222");
        stack.add("333");
        String s3 = orderFeignService.test12(order, stack);

        return s0 + "\n" +
                s1  + "\n" +
                s2  + "\n" +
                s3 ;
    }

    @GetMapping("/test13")
    @ResponseBody
    public String test13(){
        Order order = new Order(666, "马坤", "uiojns");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("111");
        linkedList.add("222");
        linkedList.add("333");
        String s0 = orderFeignService.test13(linkedList);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("111");
        arrayList.add("222");
        arrayList.add("333");
        String s1 = orderFeignService.test13( arrayList);

        Vector<String> vector = new Vector<>();
        vector.add("111");
        vector.add("222");
        vector.add("333");
        String s2 = orderFeignService.test13(vector);

        Stack<String> stack = new Stack<>();
        stack.add("111");
        stack.add("222");
        stack.add("333");
        String s3 = orderFeignService.test13( stack);

        return s0 + "\n" +
                s1  + "\n" +
                s2  + "\n" +
                s3 ;
    }

    @GetMapping("/test14")
    @ResponseBody
    public String test14() {
        Order order = new Order(666, "马坤", "uiojns");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("111");
        linkedList.add("222");
        linkedList.add("333");
        String s0 = orderFeignService.test14(linkedList);

        return s0;
    }

    @GetMapping("/test15")
    @ResponseBody
    public String test15() {
        Order order = new Order(666, "马坤", "uiojns");
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0 ; i < 1000 ; i++){
            linkedList.add(i + "" + i + "" + i + "||");
        }
        String s0 = orderFeignService.test15(linkedList);

        return s0;
    }

    @GetMapping("/test16")
    @ResponseBody
    public String test16() {
        Order order = new Order(666, "马坤", "uiojns");
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0 ; i < 1000 ; i++){
            linkedList.add(i + "" + i + "" + i + "||");
        }
        String s0 = orderFeignService.test16(linkedList);

        return s0;
    }

    @GetMapping("/test17")
    @ResponseBody
    public String test17() {
        Order order = new Order(666, "马坤", "uiojns");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("111");
        linkedList.add("222");
        linkedList.add("333");
        ArrayList<Integer> strings = new ArrayList<>();
        strings.add(222);
        strings.add(4444);
        strings.add(466546);
        String s0 = orderFeignService.test17(linkedList,strings);

        return s0;
    }

    @GetMapping("/test18")
    @ResponseBody
    public String test18() {
        Order order = new Order(666, "马坤", "uiojns");
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0 ; i < 1000 ; i++){
            linkedList.add(i + "" + i + "" + i + "||");
        }

        String s0 = orderFeignService.test18(linkedList, "马坤", 3456);

        return s0;
    }

}
