package com.lee.gmall.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class WareOrderTask {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long orderId;
  private String consignee;
  private String consigneeTel;
  private String deliveryAddress;
  private String orderComment;
  private String paymentWay;
  private String taskStatus;
  private String orderBody;
  private String trackingNo;
  private java.sql.Timestamp createTime;
  private long wareId;
  private String taskComment;


}
