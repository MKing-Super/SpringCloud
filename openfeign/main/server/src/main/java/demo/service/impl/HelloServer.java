package demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import demo.feign.HelloFeign;
import demo.home.feign.HomeFeign;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @Author: kun.ma
 * @Date: 2023/2/17 11:26
 */
@RestController
@RequestMapping("/hello")
public class HelloServer implements HelloFeign {


    @Autowired
    DiscoveryClient client;
    @Autowired
    HomeFeign homeFeign;

    @RequestMapping("/index")
    public String hello() {
        List<ServiceInstance> instances = client.getInstances("HelloServer");
        String client = homeFeign.client();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("HELLOSERVER", "Hello Server");
        jsonObject.put("HOMESERVER", client);
        return jsonObject.toJSONString();
    }

    @RequestMapping("/date")
    public Date date(Date date) {
        if (date == null) {
            return null;
        } else {
            return DateUtils.addDays(date, 2);
        }
    }

}
