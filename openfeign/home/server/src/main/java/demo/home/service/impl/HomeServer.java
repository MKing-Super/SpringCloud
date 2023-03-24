package demo.home.service.impl;

import demo.home.feign.HomeFeign;
import demo.world.feign.WorldFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @Autowired
    WorldFeign worldFeign;

    @RequestMapping("/client")
    public String client() {
        List<ServiceInstance> instances = client.getInstances("HelloServer");
        String description = client.description();
        return description;
    }

    @Override
    public String hello(String name) {
        String world = worldFeign.hello();
        return "home hello~ " + name + world;
    }
}
