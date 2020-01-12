package com.lee.gmall.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class WareOrderTaskDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long skuId;
  private String skuName;
  private long skuNums;
  private long taskId;
  private long skuNum;

}
