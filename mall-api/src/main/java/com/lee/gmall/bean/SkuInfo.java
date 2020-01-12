package com.lee.gmall.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
@Data
public class SkuInfo implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC", strategy = GenerationType.IDENTITY)//增加这个注解解决了通用Mapper的insert不返回主键的问题
    private Long id;
    private Long spuId;
    private BigDecimal price;
    private String skuName;
    private String skuDesc;
    private String weight;
    /**
     * 品牌id
     */
    private String tmId;
    private String catalog3Id;
    private String skuDefaultImg;

    @Transient
    List<SkuImage> skuImageList;
    @Transient
    List<SkuAttrValue> skuAttrValueList;
    @Transient
    List<SkuSaleAttrValue> skuSaleAttrValueList;
}
