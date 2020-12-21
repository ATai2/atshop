package com.atshop.goods.service;




import com.at.common.bean.PmsBaseAttrInfo;
import com.at.common.bean.PmsBaseAttrValue;
import com.at.common.bean.PmsBaseSaleAttr;

import java.util.List;


public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> baseSaleAttrList();
}
