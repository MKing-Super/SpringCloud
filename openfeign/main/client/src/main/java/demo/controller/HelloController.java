package demo.controller;

import demo.feign.HelloFeign;

import demo.home.feign.HomeFeign;
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
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    HelloFeign helloFeign;
    @Autowired
    HomeFeign homeFeign;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        String mk = homeFeign.hello();
        String look = homeFeign.look();
//        String hello = client.hello();
//        JSONObject jsonObject = JSON.parseObject(hello);
//        Date date = client.date(new Date());
//        jsonObject.put("currTime",date);
//        jsonObject.put("name",mk);
        return "main hello ~ " + "||" + mk + look;
    }

    /**
     * @describe: 模拟异常
     * @param: []
     * @return: java.lang.String
     * @author: MK
     * @version: 1.0.0
     * @date 2023/2/22 11:01
     **/
    @ResponseBody
    @RequestMapping("/exception")
    public String exception() {
        return 1 / 0 + "";
    }


}
