package com.atshop.user.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@ToString
@Data
@Entity(name = "Product")
public class Product {

    @Id
    private Integer id;

    private String sku;

//    @org.hibernate.annotations.Type( type = "nstring" )
    private String name;

//    @org.hibernate.annotations.Type( type = "materialized_nclob" )
    private String description;

//    @Enumerated(EnumType.ORDINAL)
    @Column(name = "phone_type")
    private String phoneType;

}