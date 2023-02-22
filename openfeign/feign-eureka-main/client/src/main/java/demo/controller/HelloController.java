package demo.controller;

import demo.api.HelloClientFeign;
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
    HelloClientFeign client;

    @ResponseBody
    @RequestMapping("/index")
    public String hello() {
        return client.hello();
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
    public String exception(){
        return 1/0 + "";
    }

    @ResponseBody
    @RequestMapping("/date")
    public Date date(){
        Date date = client.date(new Date());
        if (date == null){
            return null;
        }else {
            return DateUtils.addDays(date,1);
        }
    }

}
