package com.atshop.security.entity;


import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Table(name = "s_user")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @NotBlank(message = "用户名不能为null")
    @Column(unique = true)
    private String userName;
    @NotBlank
    private String password;

    private String permissions;

    public UserInfo buildInfo(){
        UserInfo userInfo=new UserInfo();
        BeanUtils.copyProperties(this, userInfo);
        return userInfo;
    }
}
