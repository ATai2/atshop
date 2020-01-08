package com.lee.gmall.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@Configuration
@CrossOrigin
public class GmallManageWebApplication {

    public static void main(String[] args) {

        SpringApplication.run(GmallManageWebApplication.class, args);

    }

    //修改springboot默认上传文件大小
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize(DataSize.ofMegabytes(10240)); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.ofKilobytes(10240));
        return factory.createMultipartConfig();
    }
}
