package demo.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Spencer Gibb
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"demo"})
public class HomeServerApplication {


    public static void main(String[] args) {
        SpringApplication.run(HomeServerApplication.class, args);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>");
    }
}
