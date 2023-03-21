package demo.service.impl;

import demo.feign.HomeFeign;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Description: TODO
 * @Author: kun.ma
 * @Date: 2023/2/17 11:26
 */
@RestController
@RequestMapping("/home")
public class HomeServer implements HomeFeign {


    @Autowired
    DiscoveryClient client;

    @RequestMapping("/client")
    public String client() {
        List<ServiceInstance> instances = client.getInstances("HelloServer");
        String description = client.description();
        return description;
    }

    @Override
    public String hello(String name) {
        return "hello" + name;
    }
}
