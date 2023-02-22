package demo.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @Description: TODO
 * @Author: kun.ma
 * @Date: 2023/2/17 11:15
 */
@FeignClient(value = "HelloServer",path = "/hello")
public interface HelloClientFeign {

    @RequestMapping(value = "/index", method = GET)
    String hello();

    @RequestMapping(value = "/date",method = GET)
    Date date(@RequestParam("date") Date date);

}
