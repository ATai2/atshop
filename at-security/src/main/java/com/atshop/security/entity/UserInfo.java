package com.atshop.security.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
public class UserInfo {

    private Long id;
    @NotBlank(message = "用户名不能为空")
    private String userName;
    @NotBlank(message = "密码不能为空")
    private String password;

    private String permissions;

}
