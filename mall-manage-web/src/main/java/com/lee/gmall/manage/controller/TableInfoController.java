package com.lee.gmall.manage.controller;


import com.lee.gmall.service.TableInfoService;
import io.swagger.annotations.Api;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class TableInfoController {
    @Reference
    TableInfoService tableInfoService;

    @GetMapping("/tableInfo")
    public Object getTableInfo(String tableName){
        return tableInfoService.getTableInfo(tableName);
    }

}
