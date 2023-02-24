package demo.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @describe: TODO
 * @Author MK
 * @PackageName feign-eureka-main
 * @Package demo.api
 * @Date 2023/2/22 13:47
 * @Version 1.0
 */
@FeignClient(value = "HomeServer",path = "/home")
public interface HomeFeign {

    @RequestMapping(value = "/client",method = RequestMethod.GET)
    String client();

}
