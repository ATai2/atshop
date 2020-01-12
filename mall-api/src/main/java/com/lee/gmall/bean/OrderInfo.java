package com.lee.gmall.bean;

import com.lee.gmall.enums.PaymentWay;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Data
public class OrderInfo implements Serializable {

    //增加这个注解解决了通用Mapper的insert不返回主键的问题
    @Id
    @GeneratedValue(generator = "JDBC", strategy = GenerationType.IDENTITY)
    private Long id;
    private String consignee;
    private BigDecimal totalAmount;
    private String orderStatus;
    private String userId;
    private PaymentWay paymentWay;
    private Date expectDeliveryTime;
    private String deliveryAddress;
    private String orderComment;
    private String outTradeNo;
    private String tradeBody;
    private Date createTime;
    private Date expireTime;
    private String wareStatus;
    private String parentOrderId;
    private String processStatus;
    private String trackingNo;
    private String consigneeTel;

    @Transient
    List<OrderDetail> orderDetailList;
}
