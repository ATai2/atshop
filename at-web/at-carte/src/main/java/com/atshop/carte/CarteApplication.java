package com.atshop.carte;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@EnableSwagger2
@MapperScan(basePackages = "com.atshop.carte.mapper")
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class CarteApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarteApplication.class, args);
    }
}
