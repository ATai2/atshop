package com.lee.gmall.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class SkuLsAttrValue implements Serializable {
    String valueId;
}
