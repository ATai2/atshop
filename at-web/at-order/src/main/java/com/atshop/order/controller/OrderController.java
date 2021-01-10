package com.atshop.order.controller;

import com.atshop.order.entity.OrderInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {



    @PostMapping
//    public OrderInfo create(@RequestBody OrderInfo info, @AuthenticationPrincipal User user) {
//    public OrderInfo create(@RequestBody OrderInfo info, @AuthenticationPrincipal(expression = "#this.id") Long userId) {
    public OrderInfo create(@RequestBody OrderInfo info, @RequestHeader("username") String userId) {
        log.info("user is "+userId);

        return info;
    }
}
