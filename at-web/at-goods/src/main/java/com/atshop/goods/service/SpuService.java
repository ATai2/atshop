package com.atshop.goods.service;


import com.atshop.goods.entity.PmsProductInfo;

import java.util.List;

public interface SpuService {
    List<PmsProductInfo> spuList(String catalog3Id);
}
