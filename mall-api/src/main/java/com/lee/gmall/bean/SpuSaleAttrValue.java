package com.lee.gmall.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
@Data
public class SpuSaleAttrValue implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  private Long spuId;
  private String saleAttrId;
  private String saleAttrValueName;

    @Transient
    private String isChecked;

}
