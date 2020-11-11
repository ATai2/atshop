package com.atshop.security.config;

import com.atshop.security.filter.AuditLogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

//打开jpa审计总开关
@EnableJpaAuditing
public class SecurityConfig implements WebMvcConfigurer {
    @Autowired
    private AuditLogInterceptor auditLogInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(auditLogInterceptor);


    }
}
