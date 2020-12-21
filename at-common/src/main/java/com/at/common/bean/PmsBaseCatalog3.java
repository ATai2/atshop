package com.at.common.bean;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class PmsBaseCatalog3 implements Serializable {

    @Id
    private String id;
    private String name;
    private String catalog2Id;
}
