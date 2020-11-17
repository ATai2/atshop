package com.atshop.user.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Product")
public class Product {

    @Id
    private Integer id;

    private String sku;

    @org.hibernate.annotations.Type( type = "nstring" )
    private String name;

    @org.hibernate.annotations.Type( type = "materialized_nclob" )
    private String description;
}