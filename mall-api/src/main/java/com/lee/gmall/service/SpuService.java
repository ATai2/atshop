package com.lee.gmall.service;

import com.lee.gmall.bean.*;

import java.util.List;
import java.util.Map;

public interface SpuService {
    List<SpuInfo> spuList(String catalog3Id);

    List<BaseSaleAttr> baseSaleAttrList();

    void saveSpu(SpuInfo spuInfo);

    List<SpuImage> getSpuImageList(Long spuId);

    List<SpuSaleAttr> getSpuSaleAttrList(Long spuId);

    void deleteSpu(Long spuId);

    List<SpuSaleAttr> getSpuSaleAttrListBySpuId(Long spuId);

    List<SpuSaleAttr> getSpuSaleAttrListCheckBySku(Map<String, Object> idMap);

    List<SkuInfo> getSkuSaleAttrValueListBySpu(Long spuId);
}
