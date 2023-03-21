package demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @describe: TODO
 * @Author MK
 * @PackageName home
 * @Package demo.feign
 * @Date 2023/3/20 17:49
 * @Version 1.0
 */
@FeignClient(value = "HomeServer",path = "/home")
public interface HomeFeign {

    @RequestMapping(value = "/client",method = RequestMethod.GET)
    String client();

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

}
