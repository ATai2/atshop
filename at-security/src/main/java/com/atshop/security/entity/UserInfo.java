package com.atshop.security.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
public class UserInfo {

    private Long id;
    private String userName;
    private String password;

    private String permissions;

}
