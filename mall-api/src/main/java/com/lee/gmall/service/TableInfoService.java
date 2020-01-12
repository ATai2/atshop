package com.lee.gmall.service;

import com.lee.gmall.entity.TableDataReq;

public interface TableInfoService {
    Object getTableInfo(String tableName);

    Object getTableNames();

    Object getTableData(TableDataReq tableDataReq);

    Object deleteData(TableDataReq tableDataReq);

    Object updateData(TableDataReq tableDataReq);

    Object addData(TableDataReq tableDataReq);
}
