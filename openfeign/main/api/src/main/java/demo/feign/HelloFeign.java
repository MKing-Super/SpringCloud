package demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @describe: TODO
 * @Author MK
 * @PackageName feign-eureka-main
 * @Package demo.feign
 * @Date 2023/3/20 17:57
 * @Version 1.0
 */
@FeignClient(value = "HelloServer",path = "/hello")
public interface HelloFeign {

    @RequestMapping(value = "/index", method = GET)
    String hello();

    @RequestMapping(value = "/date",method = GET)
    Date date(@RequestParam("date") Date date);

}
