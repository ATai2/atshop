package com.lee.gmall.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class SkuLsParam implements Serializable{

    String  catalog3Id;

    String[] valueId;

    String keyword;

    int  pageNo=1;

    int pageSize=20;


}
