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
public class SkuLsInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    BigDecimal price;

    String skuName;

    String skuDesc;

    String catalog3Id;

    String skuDefaultImg;

    Long hotScore = 0L;

    @Transient
    List<SkuLsAttrValue> skuAttrValueList;

  }
