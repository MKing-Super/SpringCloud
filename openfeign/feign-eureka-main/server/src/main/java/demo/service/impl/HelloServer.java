package demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * @Description: TODO
 * @Author: kun.ma
 * @Date: 2023/2/17 11:26
 */
@RestController
@RequestMapping("/hello")
public class HelloServer {


    @Autowired
    DiscoveryClient client;

    @RequestMapping("/index")
    public String hello() {
        List<ServiceInstance> instances = client.getInstances("HelloServer");
        ServiceInstance selectedInstance = instances
                .get(new Random().nextInt(instances.size()));
        return "Hello World: " + selectedInstance.getServiceId() + ":" + selectedInstance
                .getHost() + ":" + selectedInstance.getPort();
    }

}
