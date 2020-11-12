package com.atshop.security.filter;

import com.atshop.security.entity.User;
import com.atshop.security.repository.UserRepository;
import com.lambdaworks.crypto.SCryptUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Component
@Order(2)
public class BasicAuthecationFilter extends OncePerRequestFilter {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = httpServletRequest.getHeader("Authorization");
        if (StringUtils.isNotBlank(authHeader)) {
            String token64 = StringUtils.substringAfter(authHeader, "Basic ");
            String token = new String(Base64Utils.decodeFromString(token64));
            String[] items = StringUtils.split(token, ":");
            String username = items[0];
            String password = items[1];
            User user = userRepository.findByUserName(username);

            if (user != null && SCryptUtil.check(password, user.getPassword())) {
//            if (user != null && StringUtils.equals(password, user.getPassword())) {
                httpServletRequest.setAttribute("user", user.buildInfo());
                httpServletRequest.setAttribute("temp", "yes");
            }
        }
//  支持basic方法和login访问
        try {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } finally {
            HttpSession session = httpServletRequest.getSession();
            if (session.getAttribute("temp") != null) {
                session.invalidate();
            }
        }


    }
}
