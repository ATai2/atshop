package com.atshop.item.service;

import com.atshop.item.entity.PmsProductInfo;

import java.util.List;

@FeignClient(name="at-goods")
public interface ItemService {
    List<PmsProductInfo> spuList(String catalog3Id);
}
