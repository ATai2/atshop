package com.atshop.carte.rest;

import com.at.common.bean.PmsSkuInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "at-goods")
public interface SkuRestService {
//    @RequestMapping("spuList")
//    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    @GetMapping("getSkuById")
    PmsSkuInfo getSkuById(@RequestParam String skuId, @RequestParam String ip);

//    @RequestMapping("spuList")
//    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId);

//    @RequestMapping("spuList")
//    List<PmsSkuInfo> getAllSku(String catalog3Id);
}