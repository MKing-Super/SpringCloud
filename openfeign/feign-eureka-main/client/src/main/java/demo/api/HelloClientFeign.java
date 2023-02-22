package demo.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @Description: TODO
 * @Author: kun.ma
 * @Date: 2023/2/17 11:15
 */
@FeignClient(value = "HelloServer",path = "/")
public interface HelloClientFeign {

    @RequestMapping(value = "/", method = GET)
    String hello();

}
