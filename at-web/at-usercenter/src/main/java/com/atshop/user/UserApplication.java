package com.atshop.user;

import com.atshop.service.conf.RedisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackageClasses = {UserApplication.class, RedisConfig.class})
//@ComponentScan(includeFilters = {})
@MapperScan(basePackages = "com.atshop.user.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
