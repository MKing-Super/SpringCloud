package demo.controller;

import demo.api.HelloClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: TODO
 * @Author: kun.ma
 * @Date: 2023/2/17 11:16
 */

@Controller
public class HelloController {

    @Autowired
    HelloClientFeign client;

    @ResponseBody
    @RequestMapping("/")
    public String hello() {
        return client.hello();
    }

}