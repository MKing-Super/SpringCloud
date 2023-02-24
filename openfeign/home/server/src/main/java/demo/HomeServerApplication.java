package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Spencer Gibb
 */
@SpringBootApplication
@EnableDiscoveryClient
public class HomeServerApplication {


    public static void main(String[] args) {
        SpringApplication.run(HomeServerApplication.class, args);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>");
    }
}
