package com.atshop.search.dto;

import lombok.Data;

@Data
public class SaveBean {
    private String index;
    private String type;
    private String id;
    private String dataJson;
}
