package com.atshop.goods.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
public class PriceInfo {

    private Long id;
    private BigDecimal price;

}
