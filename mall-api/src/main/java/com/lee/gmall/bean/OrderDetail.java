package com.lee.gmall.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
@Data
public class OrderDetail implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private Long skuId;
    private String skuName;
    private String imgFileName;
    private BigDecimal orderPrice;
    private Integer skuNums;
    private String logisticsId;
    private String imgUrl;
    private Integer skuNum;

    @Transient
    private String hasStock;
}
