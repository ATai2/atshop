package com.lee.gmall.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class BaseCatalog1Tm {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long tmId;
  private String catalog1Id;
}
