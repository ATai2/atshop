package com.lee.gmall.bean;

import lombok.Data;

@Data
public class OrderLogistics {

  private long id;
  private long orderId;
  private String logisticsStatus;
  private String logisticsNo;
  private java.sql.Timestamp createTime;
}
