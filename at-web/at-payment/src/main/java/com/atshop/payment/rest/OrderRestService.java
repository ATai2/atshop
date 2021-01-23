package com.atshop.payment.rest;

import com.at.common.bean.OmsOrder;
import com.at.common.bean.PmsSkuInfo;
import com.at.common.service.OrderService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "at-order")
public interface OrderRestService extends OrderService {
    @Override
    void updateOrder(OmsOrder omsOrder);

    //    @RequestMapping("spuList")
//    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    @GetMapping("getSkuById")
    PmsSkuInfo getSkuById(@RequestParam String skuId, @RequestParam String ip);

//    @RequestMapping("spuList")
//    List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId);

//    @RequestMapping("spuList")
//    List<PmsSkuInfo> getAllSku(String catalog3Id);
}