package com.atshop.goods.controller;


import com.at.common.bean.PmsProductSaleAttr;
import com.at.common.bean.PmsSkuInfo;
import com.atshop.goods.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkuController {

    @Autowired
    private SkuService skuService;

    @GetMapping("getSkuById")
    PmsSkuInfo getSkuById(@RequestParam String skuId) {
        return skuService.getSkuById(skuId);
    }

    @GetMapping("spuSaleAttrListCheckBySku")
    List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(@RequestParam String productId, @RequestParam  String id) {
        return null;
    }

    @GetMapping("getSkuSaleAttrValueListBySpu")
    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(@RequestParam String productId) {
        return skuService.getSkuSaleAttrValueListBySpu(productId);
    }
}
