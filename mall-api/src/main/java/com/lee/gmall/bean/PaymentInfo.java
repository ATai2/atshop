package com.lee.gmall.bean;

import lombok.Data;

@Data
public class PaymentInfo {

  private long id;
  private String outTradeNo;
  private Long orderId;
  private String alipayTradeNo;
  private double totalAmount;
  private String subject;
  private String paymentStatus;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp confirmTime;
  private String callbackContent;
  private java.sql.Timestamp callbackTime;
}
