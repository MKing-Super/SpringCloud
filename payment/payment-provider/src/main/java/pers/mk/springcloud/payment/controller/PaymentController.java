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
import org.springframework.web.bind.annotation.RestController;
import pers.mk.springcloud.payment.model.CommonResult;
import pers.mk.springcloud.payment.model.Order;
import pers.mk.springcloud.payment.model.Payment;
import pers.mk.springcloud.payment.model.PaymentAndOrder;
import pers.mk.springcloud.payment.service.PaymentService;

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
}
