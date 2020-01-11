package com.lee.gmall.manage.service.impl;

import com.lee.gmall.bean.ColumnInfo;
import com.lee.gmall.bean.SkuInfo;
import com.lee.gmall.bean.SpuInfo;
import com.lee.gmall.bean.TableDataReq;
import com.lee.gmall.manage.mapper.*;
import com.lee.gmall.service.TableInfoService;
import com.lee.gmall.utils.NameUtils;
import org.apache.dubbo.config.annotation.Service;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public Object getTableInfo(String tableName) {
        List<ColumnInfo> columnInfos = tableInfoMapper.tableColumnInfo(tableName);
        columnInfos.forEach(new Consumer<ColumnInfo>() {
            @Override
            public void accept(ColumnInfo columnInfo) {
                columnInfo.setColumnName(NameUtils.lineToHump(columnInfo.getColumnName()));
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
        switch (tableDataReq.getTableName()) {
            case "sku_info":
                return skuInfoMapper.selectAll();
            case "spu_info":
                return spuInfoMapper.selectAll();
        }
        return null;
    }

    @Override
    public Object deleteData(TableDataReq tableDataReq) {
        switch (tableDataReq.getTableName()) {
            case "sku_info":
                return skuInfoMapper.deleteByPrimaryKey(tableDataReq.getId());
            case "spu_info":
                return spuInfoMapper.deleteByPrimaryKey(tableDataReq.getId());
        }
        return null;
    }

    @Override
    public Object updateData(TableDataReq tableDataReq) {
        switch (tableDataReq.getTableName()) {
            case "sku_info":
                return skuInfoMapper.updateByPrimaryKey((SkuInfo) tableDataReq.getData());
            case "spu_info":
                return spuInfoMapper.updateByPrimaryKey((SpuInfo) tableDataReq.getData());
        }
        return null;
    }
}
