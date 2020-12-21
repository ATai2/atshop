package com.at.common.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
@Data
public class PmsProductSaleAttrValue implements Serializable {
    @Id
    @Column
    String id ;

    @Column
    String productId;

    @Column
    String saleAttrId;

    @Column
    String saleAttrValueName;

    @Transient
    String isChecked;

}
