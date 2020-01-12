package com.lee.gmall.manage.controller;


import com.lee.gmall.entity.TableDataReq;
import com.lee.gmall.resp.SysLog;
import com.lee.gmall.service.TableInfoService;
import io.swagger.annotations.Api;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@SysLog

@Api
@RestController
public class TableInfoController {
    @Reference
    TableInfoService tableInfoService;

    @SysLog
    @GetMapping("/tableInfo")
    public Object getTableInfo(String tableName) {
        return tableInfoService.getTableInfo(tableName);
    }

    @SysLog

    @PostMapping("/table")
    public Object getTableData(TableDataReq tableDataReq) {
        return tableInfoService.getTableData(tableDataReq);
    }

    @SysLog

    @PostMapping("/getTableNames")
    public Object getTableNames() {
        return tableInfoService.getTableNames();
    }

    @SysLog

    @PostMapping("/deleteData")
    public Object deleteData(TableDataReq tableDataReq) {
        Object o = tableInfoService.deleteData(tableDataReq);
        return o;
    }

    @SysLog

    @PostMapping("/updateData")
    public Object updateData(TableDataReq tableDataReq) {
        Object o = tableInfoService.updateData(tableDataReq);
        return o;
    }    @PostMapping("/addData")
    public Object addData(TableDataReq tableDataReq) {
        Object o = tableInfoService.addData(tableDataReq);
        return o;
    }

}
