package com.lee.gmall.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long idCard;
  private long userId;
  private String userPhone;
  private String hometown;
  private long addressId;
  private String sex;
  private java.sql.Timestamp createTime;


}
