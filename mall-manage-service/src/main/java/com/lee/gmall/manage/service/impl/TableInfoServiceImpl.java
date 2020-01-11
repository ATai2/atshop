package com.lee.gmall.manage.service.impl;

import com.lee.gmall.manage.mapper.TableInfoMapper;
import com.lee.gmall.service.TableInfoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TableInfoServiceImpl implements TableInfoService {
    @Autowired
    TableInfoMapper tableInfoMapper;

    @Override
    public Object getTableInfo(String tableName){
        return tableInfoMapper.tableColumnInfo(tableName);
    }
}
