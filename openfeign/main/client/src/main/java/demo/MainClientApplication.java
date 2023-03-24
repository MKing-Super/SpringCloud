package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Spencer Gibb
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"demo"})
public class MainClientApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainClientApplication.class, args);
        String id = run.getId();
        System.out.println(id);
        System.out.println(">>>>>>>>>>>>>>>>>>>.");
    }

}
