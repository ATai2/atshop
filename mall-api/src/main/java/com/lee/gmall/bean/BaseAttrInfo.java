package com.lee.gmall.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Data
public class BaseAttrInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String attrName;
    private String catalog3Id;
    private String isEnabled;
    @Transient
    List<BaseAttrValue> attrValueList;
}
