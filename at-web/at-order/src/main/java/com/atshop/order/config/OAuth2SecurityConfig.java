package com.atshop.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableWebSecurity
public class OAuth2SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public ResourceServerTokenServices tokenServices() {
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setClientId("orderService");
        tokenServices.setClientSecret("123456");
        tokenServices.setCheckTokenEndpointUrl("http://localhost:9030/oauth/token");
        return tokenServices;
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        OAuth2AuthenticationManager auth2AuthenticationManager=new OAuth2AuthenticationManager();
        auth2AuthenticationManager.setTokenServices(tokenServices());
        return auth2AuthenticationManager;
    }
}
