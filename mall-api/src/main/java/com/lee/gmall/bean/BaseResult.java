package com.lee.gmall.bean;

import lombok.Data;

@Data
public class BaseResult<T> {
    boolean success;
    String msg;
    T data;
}
