package com.atshop.goods.service;


import com.atshop.goods.entity.PmsBaseAttrInfo;

import java.util.List;


public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);
}
