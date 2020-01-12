package com.lee.gmall.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class CartInfo implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long skuId;
    private BigDecimal cartPrice;
    private long quantity;
    private String imgUrl;
    private String isChecked;
    private BigDecimal skuPrice;
    private Integer skuNum;
    private String skuName;
}
