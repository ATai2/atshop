package com.lee.gmall.manage.service.impl;

import com.alibaba.fastjson.JSON;
import com.lee.gmall.entity.ColumnInfo;
import com.lee.gmall.entity.TableDataReq;
import com.lee.gmall.manage.mapper.*;
import com.lee.gmall.service.TableInfoService;
import com.lee.gmall.utils.NameChangeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Service
public class TableInfoServiceImpl implements TableInfoService {
    @Autowired
    TableInfoMapper tableInfoMapper;

    @Autowired
    SkuInfoMapper skuInfoMapper;
    @Autowired
    SkuImageMapper skuImageMapper;
    @Autowired
    SkuAttrValueMapper skuAttrValueMapper;
    @Autowired
    SkuSaleAttrValueMapper skuSaleAttrValueMapper;

    @Autowired
    SpuInfoMapper spuInfoMapper;

    @Autowired
    Map<String, Mapper> mapperMap;

    @Override
    public Object getTableInfo(String tableName) {
        List<ColumnInfo> columnInfos = tableInfoMapper.tableColumnInfo(tableName);
        columnInfos.forEach(new Consumer<ColumnInfo>() {
            @Override
            public void accept(ColumnInfo columnInfo) {
                columnInfo.setColumnName(NameChangeUtils.lineToHump(columnInfo.getColumnName()));
            }
        });

        return columnInfos;
    }

    @Override
    public Object getTableNames() {
        return tableInfoMapper.tableNames();
    }

    @Override
    public Object getTableData(TableDataReq tableDataReq) {
        return excuteMapperMethod(tableDataReq).selectAll();
    }

    @Override
    public Object deleteData(TableDataReq tableDataReq) {
        String beanName = StringUtils.capitalize(NameChangeUtils.lineToHump(tableDataReq.getTableName()));
        try {
            return excuteMapperMethod(tableDataReq).delete(JSON.parseObject((String) tableDataReq.getData(), Class.forName("com.lee.gmall.bean." + beanName)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object updateData(TableDataReq tableDataReq) {
        String beanName = StringUtils.capitalize(NameChangeUtils.lineToHump(tableDataReq.getTableName()));
        try {
            return excuteMapperMethod(tableDataReq).updateByPrimaryKey(JSON.parseObject((String) tableDataReq.getData(), Class.forName("com.lee.gmall.bean." + beanName)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object addData(TableDataReq tableDataReq) {
        String beanName = StringUtils.capitalize(NameChangeUtils.lineToHump(tableDataReq.getTableName()));
        try {
            return excuteMapperMethod(tableDataReq).insert(JSON.parseObject((String) tableDataReq.getData(), Class.forName("com.lee.gmall.bean." + beanName)));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Mapper excuteMapperMethod(TableDataReq tableDataReq) {
        String tableName =  NameChangeUtils.lineToHump(tableDataReq.getTableName())+"Mapper";
        return mapperMap.get(tableName);
    }
}
