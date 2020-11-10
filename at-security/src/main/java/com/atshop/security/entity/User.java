package com.atshop.security.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table(name = "s_user")
@Entity
@Data
public class User {
    @Id
    private Long id;
    @NotBlank(message = "用户名不能为null")
    @Column(unique = true)
    private String userName;
    @NotBlank
    private String password;

    private String permissions;

}
