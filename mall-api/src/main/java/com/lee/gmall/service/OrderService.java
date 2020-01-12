package com.lee.gmall.service;

import com.lee.gmall.bean.OrderInfo;

public interface OrderService {
    String genTradeCode(Long userId);

    boolean checkTradeCode(String tradeCode, Long userId);

    void saveOrder(OrderInfo orderInfo);
}
