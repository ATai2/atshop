package com.atshop.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.*;

@Configuration
@EnableWebSecurity
public class OAuth2SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailServiceImpl;

    @Bean
    public ResourceServerTokenServices tokenServices() {
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setClientId("orderService");
        tokenServices.setClientSecret("123456");
        tokenServices.setCheckTokenEndpointUrl("http://localhost:9030/oauth/token");
        tokenServices.setAccessTokenConverter(getAccessTokenConverter());
        return tokenServices;
    }

//    设置userService   @AuthenticationPrincipal User user
    private AccessTokenConverter getAccessTokenConverter() {
        DefaultAccessTokenConverter accessTokenConverter=new DefaultAccessTokenConverter();
        DefaultUserAuthenticationConverter userAuthenticationConverter=new DefaultUserAuthenticationConverter();
        userAuthenticationConverter.setUserDetailsService(userDetailServiceImpl);
        accessTokenConverter.setUserTokenConverter(userAuthenticationConverter);
        return accessTokenConverter;
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        OAuth2AuthenticationManager auth2AuthenticationManager=new OAuth2AuthenticationManager();
        auth2AuthenticationManager.setTokenServices(tokenServices());
        return auth2AuthenticationManager;
    }
}
