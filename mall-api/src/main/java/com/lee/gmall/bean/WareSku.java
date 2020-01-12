package com.lee.gmall.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class WareSku {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long skuId;
  private long warehouseId;
  private long stock;
  private String stockName;
  private long stockLocked;

}
