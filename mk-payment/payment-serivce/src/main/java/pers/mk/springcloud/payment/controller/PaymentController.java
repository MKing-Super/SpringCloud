package pers.mk.springcloud.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pers.mk.springcloud.payment.common.CommonResult;
import pers.mk.springcloud.payment.model.Payment;
import pers.mk.springcloud.payment.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PaymentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    @Resource
    private PaymentService paymentService;

    //对于注册进eureka里面的微服务，可以通过服务发现来获得该服务的信息
    @Resource
    private DiscoveryClient discoveryClient;

    //获取配置文件yml中的端口信息
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        LOGGER.info("***查看结果：" + payment.toString() );
        if(payment != null)
        {
            return new CommonResult(200,"查询成功，serverPort：","");
        }else{
            return new CommonResult(444,"没有对应记录,查询ID: "+id,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            LOGGER.info("*****element: "+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            LOGGER.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
