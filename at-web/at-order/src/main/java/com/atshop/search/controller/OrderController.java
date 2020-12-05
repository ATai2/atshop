package com.atshop.search.controller;

import com.atshop.search.entity.OrderInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

    private RestTemplate restTemplate=new RestTemplate();

    @PostMapping
//    public OrderInfo create(@RequestBody OrderInfo info, @AuthenticationPrincipal User user) {
//    public OrderInfo create(@RequestBody OrderInfo info, @AuthenticationPrincipal(expression = "#this.id") Long userId) {
    public OrderInfo create(@RequestBody OrderInfo info, @RequestHeader("username") String userId) {
        log.info("user is "+userId);

        return info;
    }
}
