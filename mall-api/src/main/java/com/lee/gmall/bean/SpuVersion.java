package com.lee.gmall.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class SpuVersion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long spuId;
  private String spuVersion;
  private String isEnabled;

}
