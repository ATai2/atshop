package com.lee.gmall.bean;

import lombok.Data;

@Data
public class OrderLog {

    private long id;
    private long orderId;
    private java.sql.Timestamp operateDate;
    private String logComment;
}
