package com.lee.gmall.bean;

import lombok.Data;

@Data
public class BaseResult<T> {
  private boolean success;
  private String msg;
  private T data;
}
