package com.at.common.bean;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
@Data
public class PmsSearchSkuInfo implements Serializable{

    @Id
    private long id;
    private String skuName;
    private String skuDesc;
    private String catalog3Id;
    private BigDecimal price;
    private String skuDefaultImg;
    private double hotScore;
    private String productId;
    private List<PmsSkuAttrValue> skuAttrValueList;


}
