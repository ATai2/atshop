package com.at.common.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class PmsSearchParam implements Serializable{

    private String catalog3Id;

    private String keyword;

    private String[] valueId;

}
