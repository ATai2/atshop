package com.atshop.item.service;

import com.atshop.item.entity.PmsProductInfo;
import com.atshop.item.entity.PmsProductSaleAttr;
import com.atshop.item.entity.PmsSkuInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "at-goods")
public interface ProductsService {
    @GetMapping("spuList")
    List<PmsProductInfo> spuList(String catalog3Id);

    @GetMapping("getSkuById")
    PmsSkuInfo getSkuById(String skuId);

    @GetMapping("spuSaleAttrListCheckBySku")
    List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(@RequestParam String productId, @RequestParam String id);

    @GetMapping("getSkuSaleAttrValueListBySpu")
    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId);

}
