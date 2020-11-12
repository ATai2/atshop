package com.atshop.order.controller;

import com.atshop.order.entity.OrderInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

    private RestTemplate restTemplate=new RestTemplate();

    @PostMapping
    public OrderInfo create(@RequestBody OrderInfo info, @AuthenticationPrincipal String username) {
        log.info("user is "+username);

        return info;
    }
}
