package com.atshop.goods.controller;

import com.atshop.goods.entity.PmsProductSaleAttr;
import com.atshop.goods.entity.PmsSkuInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SkuController {

    @GetMapping("getSkuById")
    PmsSkuInfo getSkuById(String skuId) {
        return null;
    }

    @GetMapping("spuSaleAttrListCheckBySku")
    List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(String productId, String id) {
        return null;
    }

    @GetMapping("getSkuSaleAttrValueListBySpu")
    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId) {
        return null;
    }
}
