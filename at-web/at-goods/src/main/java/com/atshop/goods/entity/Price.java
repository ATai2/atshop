package com.atshop.goods.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "at_price")
@Data
public class Price {
    @Id
    private Long id;
    private BigDecimal price;
}
