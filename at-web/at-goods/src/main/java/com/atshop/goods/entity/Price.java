package com.atshop.goods.entity;

import lombok.Data;
import org.springframework.beans.BeanUtils;

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


    public PriceInfo toInfo(){
        PriceInfo info=new PriceInfo();
        BeanUtils.copyProperties(this,info);
        return info;
    }
}
