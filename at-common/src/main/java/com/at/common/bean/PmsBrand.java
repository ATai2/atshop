package com.at.common.bean;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class PmsBrand implements Serializable {

    @Id
    private String id;
    private String name;
    private String firstLetter;
    private int sort;
    private int factoryStatus;
    private int showStatus;
    private int productCount;
    private String productCommentCount;
    private String logo;
    private String bigPic;
    private String brandStory;
}
