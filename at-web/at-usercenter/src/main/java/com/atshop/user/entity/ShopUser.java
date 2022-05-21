package com.atshop.user.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "at_user")
public class ShopUser {
    @Id
    private String id;
    private String name;
    private String address;
}
