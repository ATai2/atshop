package com.at.auth.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "at_user")
public class UserDO {
    private Long id;
    @TableField(value = "username")
    private String userName;
    private String passwd;
    private String phone;
    private String creditType;
    private Date createTime;
    private Date modifiedTime;

}
