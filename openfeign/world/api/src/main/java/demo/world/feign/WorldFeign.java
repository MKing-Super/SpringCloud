package demo.world.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @describe: TODO
 * @Author MK
 * @PackageName world
 * @Package demo.world.feign
 * @Date 2023/3/24 14:22
 * @Version 1.0
 */
@FeignClient(value = "WorldServer",path = "/world")
public interface WorldFeign {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello();

}
