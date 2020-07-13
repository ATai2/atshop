package com.at.atshop.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
public class ManageMentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageMentApplication.class, args);
    }
}