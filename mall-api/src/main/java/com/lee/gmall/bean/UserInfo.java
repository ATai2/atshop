package com.lee.gmall.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@Data
public class UserInfo implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loginName;
    private String nickName;
    private String passwd;
    private String name;
    private String phoneNum;
    private String email;
    private String headImg;
    private String userLevel;

    @Transient
    List<UserAddress> userAddressList;
}
