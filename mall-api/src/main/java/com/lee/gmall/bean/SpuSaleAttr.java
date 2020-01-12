package com.lee.gmall.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
@Data
public class SpuSaleAttr implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  private String spuId;
  private String saleAttrId;
  private String saleAttrName;

  @Transient
  private List<SpuSaleAttrValue> spuSaleAttrValueList;

  @Transient
  private Map<String, String> spuSaleAttrValueJson;

}
