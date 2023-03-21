package demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import demo.feign.HelloFeign;
import demo.feign.HomeFeign;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Description: TODO
 * @Author: kun.ma
 * @Date: 2023/2/17 11:16
 */

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    HelloFeign client;
    @Autowired
    HomeFeign homeFeign;

    @ResponseBody
    @RequestMapping("/index")
    public String hello() {
        String mk = homeFeign.hello("MK");
        String hello = client.hello();
        JSONObject jsonObject = JSON.parseObject(hello);
        Date date = client.date(new Date());
        jsonObject.put("currTime",date);
        jsonObject.put("name",mk);
        return jsonObject.toJSONString();
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
