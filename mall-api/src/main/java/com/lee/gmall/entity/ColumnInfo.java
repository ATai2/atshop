package com.lee.gmall.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ColumnInfo implements Serializable {
    String columnName;
    String columnType;
}
