package hcmute.edu.vn.uservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UServiceApplication.class, args);
    }
}
