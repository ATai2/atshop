package com.lee.gmall.entity;

import com.lee.gmall.bean.SkuLsInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class SkuLsResult implements Serializable{

    List<SkuLsInfo> skuLsInfoList;

    int Total;

    List<String> valueIdList;
}
