package com.atshop.goods.config;

import io.prometheus.client.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class PrometheusMetricsInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private Counter requestCounter;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String service=request.getRequestURI();

        requestCounter.labels(service, request.getMethod(), String.valueOf(response.getStatus()))
        .inc();
    }
}
