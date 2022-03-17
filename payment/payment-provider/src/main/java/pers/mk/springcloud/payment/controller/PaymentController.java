package pers.mk.springcloud.payment.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
import pers.mk.springcloud.payment.service.PaymentService;
import pers.mk.springcloud.payment.wrapper.PaymentComplexWrapper;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        // 判断是否插入成功
        if (result>0){
            return new CommonResult(200,"插入数据成功,serverPort"+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败,serverPort"+serverPort,null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("*****查询结果："+result);
        int a = 8/2;
        log.info(a+""+12345);
        // 判断是否插入成功
        if (result!=null){
            return new CommonResult(200,"查询成功,serverPort"+serverPort,result);
        }else {
            return new CommonResult(444,"没有对应记录，查询id："+id+"serverPort"+serverPort);
        }
    }

    @GetMapping("/discovery")
    public DiscoveryClient discovery(){
        // 得到所有服务名
        List<String> services = discoveryClient.getServices();
        services.forEach(ele->{
            log.info("***service***"+ele);
        });
        // 得到服务名对应的信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(ele->{
            log.info(ele.getServiceId()+"\t"+ele.getHost()+"\t"+ele.getPort()+"\t"+ele.getUri());
        });

        return discoveryClient;
    }

    @PostMapping("/testpost")
    public CommonResult<Payment> testpost(@RequestBody Payment payment){
        payment.setSerial("我是更过后的名字，测试成功");
        return new CommonResult<>(200,"测试成功",payment);
    }

    @GetMapping("/two")
    public CommonResult<Payment> two(Integer id,String serial){
        Payment payment = new Payment(new Long(id), serial);
        return new CommonResult<Payment>(200,"emm",payment);
    }

    @PostMapping("/complex/two")
    public CommonResult<String> complexTwo(@RequestBody Map<String,Object> map){
        Payment payment = JSON.parseObject(JSON.toJSONString(map.get("payment")), Payment.class);
        Order order = JSON.parseObject(JSON.toJSONString(map.get("order")), Order.class);
        String s = JSON.toJSONString(payment);
        String s1 = JSON.toJSONString(order);
        return new CommonResult<String>(200,"rrrrr",s + s1);
    }

    @PostMapping("/complex/two1000")
    public CommonResult<String> complexTwo1000(@RequestBody Map<String,Object> map){
        String paymentStr = (String) map.get("payment");
        String orderStr = (String) map.get("order");
        Payment payment = JSON.parseObject(paymentStr, Payment.class);
        Order order = JSON.parseObject(orderStr, Order.class);
        return new CommonResult<String>(200,"rrrrr",payment.toString() + order.toString());
    }

    @PostMapping("/complex/two1001")
    public CommonResult<PaymentAndOrder> complexTwo1001(@RequestBody PaymentAndOrder paymentAndOrder){
        Payment payment = paymentAndOrder.getPayment();
        payment.setSerial("炸了！");
        Order order = paymentAndOrder.getOrder();
        order.setUserName("这个修改后的数据~~~~");
        return new CommonResult<PaymentAndOrder>(200,"rrrrr",new PaymentAndOrder(payment,order));
    }

    @GetMapping("/test")
    public CommonResult<PaymentAndOrder> test(@RequestBody PaymentAndOrder paymentAndOrder){
        Order order = paymentAndOrder.getOrder();
        Payment payment = paymentAndOrder.getPayment();
        order.setUserName("这里是test");
        payment.setSerial("zhe li shi test");

        return new CommonResult<PaymentAndOrder>(200,"mkmkmk",paymentAndOrder);
    }

    @GetMapping("/timeout")
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "成功";
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "我是 zipkin";
    }

    @RequestMapping(value = "/complex",method = RequestMethod.POST)
    public String complex(@RequestBody PaymentComplexWrapper paymentComplexWrapper){
        Payment payment = paymentComplexWrapper.getPayment();
        Order order = paymentComplexWrapper.getOrder();
        String s = JSON.toJSONString(payment) + JSON.toJSONString(order);
        return s;
    }

    @Deprecated
    @GetMapping("/param/test")
    public String paramTest(@RequestParam("payment") Payment payment, @RequestParam("order") Order order){
        order.setUserName("这里是test");
        payment.setSerial("zhe li shi test");
        return payment.toString() + order.toString();
    }

    @GetMapping("/param/test0")
    public Integer[] paramTest0(@RequestParam("dataIds") Integer[] dataIds){
        return dataIds;
    }

    @GetMapping("/param/test1")
    public Integer[] paramTest1(@RequestParam("brand") String brand, @RequestParam("actId") Integer actId, @RequestParam("seriesIds") Integer[] seriesIds, @RequestParam("orgIds") Integer[] orgIds){
        return seriesIds;
    }

    @GetMapping("/param/test2")
    public Integer paramTest2(@RequestParam("brand") String brand, @RequestParam("actId") Integer actId){
        return actId;
    }

    @PostMapping("/param/test1")
    public CommonResult<Payment> paramTest1(@RequestBody Payment payment){
        payment.setSerial("我是更过后的名字，测试成功");
        return new CommonResult<>(200,"测试成功",payment);
    }

    @PostMapping("/param/test4")
    public CommonResult<Payment> paramTest4(@RequestBody Payment payment,@RequestParam("str") String str){
        payment.setSerial(str);
        return new CommonResult<>(200,"测试成功",payment);
    }

    @Deprecated
    @PostMapping("/param/test5")
    public String paramTest5(@RequestBody Payment payment, @RequestParam("order") Order order){
        payment.setSerial(order.getUserName());
        return payment.toString();
    }

    @PostMapping("/param/test6")
    public String paramTest6(@RequestBody List<Payment> list){
        String s = JSON.toJSONString(list);
        return s;
    }

    @GetMapping("/param/test7")
    public String paramTest7(@RequestParam("list") List<Payment> list){
        String s = JSON.toJSONString(list);
        return s;
    }

    @GetMapping("/param/test8")
    public String paramTest8(@RequestParam("list") List<Integer> list){
        String s = JSON.toJSONString(list);
        return s;
    }

    @PostMapping("/param/test9")
    public String paramTest9(@RequestParam("id") Integer id,@RequestBody List<Payment> list){
        String s = JSON.toJSONString(list);
        return s + id;
    }

    @PostMapping("/param/test10")
    public String paramTest10(@RequestBody Map<String,Object> map){
        System.out.println(map.toString());
        String s = JSON.toJSONString(map);
        return s;
    }


    @RequestMapping(value = "/param/test11",method = RequestMethod.GET)
    public String paramTest11(@RequestParam("map") Map<String,Object> map){
        System.out.println(map.toString());
        String s = JSON.toJSONString(map);
        return s;
    }

    @RequestMapping(value = "/param/test12",method = RequestMethod.GET)
    public String paramTest12(@RequestParam("arr") Payment[] arr){
        String s = arr.toString();
        return s;
    }

    @RequestMapping(value = "/param/test13",method = RequestMethod.POST)
    public String paramTest13(@RequestBody Payment[] arr){
        String s = arr.toString();
        return s;
    }

    @RequestMapping(value = "/param/test14",method = RequestMethod.GET)
    public String paramTest14(@RequestParam("list") List<Integer> list) {
        String s = list.toString();
        return s;
    }

    @RequestMapping(value = "/param/test15",method = RequestMethod.POST)
    public String paramTest15(@RequestBody List<Integer> list) {
        String s = list.toString();
        return s;
    }

    @RequestMapping(value = "/param/test16",method = RequestMethod.POST)
    public String paramTest16(@RequestParam("ll") Long ll,
                       @RequestParam("list") List<Integer> list,
                       @RequestParam("list0") List<String> list0,
                       @RequestBody Payment payment) {
        String s1 = ll.toString();
        String s2 = list.toString();
        String s = list0.toString();
        String s3 = payment.toString();
        return  s + s1 + s2 + s3;
    }







}
