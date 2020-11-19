package com.atshop.goods.config;

import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrometheusMetricConfig {
    @Autowired
    private PrometheusMeterRegistry prometheusMeterRegistry;

    @Bean
    public Counter requestCounter(){
        return Counter.build("is_request_count","cont_request_by_service")
                .labelNames("service","method","code")
                .register(prometheusMeterRegistry.getPrometheusRegistry());
    }
}
