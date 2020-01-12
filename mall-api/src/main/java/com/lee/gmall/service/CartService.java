package com.lee.gmall.service;

import com.lee.gmall.bean.CartInfo;

import java.util.List;

public interface CartService {
    CartInfo ifCartExist(CartInfo cartInfo);

    void updateCart(CartInfo cartInfoDb);

    void insertCart(CartInfo cartInfo);

    void syncCache(Long userId);

    List<CartInfo> getCartCache(Long userId);

    void updateCartChecked(CartInfo cartInfo);

    void combineCart(List<CartInfo> cartInfos, Long userId);

    List<CartInfo> getCartCacheByChecked(Long userId);

    void deleteCartById(List<CartInfo> cartInfos);
}
