package com.atshop.item.service;

import com.atshop.item.entity.PmsProductInfo;
import com.atshop.item.entity.PmsProductSaleAttr;
import com.atshop.item.entity.PmsSkuInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "at-goods")
public interface ProductsService {
    @RequestMapping("spuList")
    List<PmsProductInfo> spuList(@RequestParam String catalog3Id);

    @RequestMapping("getSkuById")
    PmsSkuInfo getSkuById(@RequestParam String skuId);

    @RequestMapping("spuSaleAttrListCheckBySku")
    List<PmsProductSaleAttr> spuSaleAttrListCheckBySku(@RequestParam String productId, @RequestParam String id);

    @RequestMapping("getSkuSaleAttrValueListBySpu")
    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(@RequestParam String productId);

}
