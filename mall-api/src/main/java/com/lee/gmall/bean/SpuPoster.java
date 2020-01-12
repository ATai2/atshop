package com.lee.gmall.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class SpuPoster {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long spuId;
  private String fileName;
  private String fileType;

}
