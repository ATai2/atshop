package com.at.common.sql;

import lombok.Data;

import java.util.List;

@Data
public class PageResult {
    private int pageNum;
    private int pageSize;
    private long total;
    private int totalPages;
    private List<?> data;
}
