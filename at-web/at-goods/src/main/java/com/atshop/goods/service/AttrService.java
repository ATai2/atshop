package com.atshop.goods.service;


import com.atshop.goods.entity.PmsBaseAttrInfo;
import com.atshop.goods.entity.PmsBaseAttrValue;
import com.atshop.goods.entity.PmsBaseSaleAttr;

import java.util.List;


public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> baseSaleAttrList();
}
