package com.lee.gmall.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Data
public class UserAddress implements Serializable {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  private String userAddress;
  private Long userId;
  private String consignee;
  private String phoneNum;
  private String isDefault;

}
