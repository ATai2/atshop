package com.atai.dmp.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "DATAELEMENT")
public class DataSourceConfEntity implements Serializable {
    private String url;
    private String username;
    private String password;
    private String driver;
//    private


}
