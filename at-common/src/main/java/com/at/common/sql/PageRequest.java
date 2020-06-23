package com.at.common.sql;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PageRequest {
    private int pageNum=-1;
    private int size=10;
    private Map<String,Object> params=new HashMap<>();
}
