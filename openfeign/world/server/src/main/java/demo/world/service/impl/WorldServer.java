package demo.world.service.impl;

import demo.world.feign.WorldFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author: kun.ma
 * @Date: 2023/2/17 11:26
 */
@RestController
@RequestMapping("/world")
public class WorldServer implements WorldFeign {


    @Autowired
    DiscoveryClient client;

    @Override
    public String hello() {
        return "world hello ~ ";
    }

    @Override
    public String look() {
        return "world look ~ ";
    }

    @Override
    public String run() {
        return "run look ~ ";
    }
}
