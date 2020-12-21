package com.atshop.carte;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
//@MapperScan(basePackages = "com.atshop.carte.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class CarteApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarteApplication.class, args);
    }
}
