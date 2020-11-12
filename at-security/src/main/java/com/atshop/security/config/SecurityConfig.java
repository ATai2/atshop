package com.atshop.security.config;

import com.atshop.security.entity.UserInfo;
import com.atshop.security.filter.AuditLogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Optional;

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

    @Bean
    public AuditorAware<String> auditorAware(){
        return () -> {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            UserInfo info = (UserInfo) requestAttributes.getRequest().getSession().getAttribute("user");
            String username=null;
            if (info != null) {
                username=info.getUserName();
            }
            return Optional.ofNullable(username);
        };
    }

}
