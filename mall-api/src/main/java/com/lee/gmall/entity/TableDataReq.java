package com.lee.gmall.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TableDataReq<T> implements Serializable {
    private String tableName;
    private Object id;
    private T data;
}
