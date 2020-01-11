package com.lee.gmall.manage.mapper;

import com.lee.gmall.bean.ColumnInfo;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TableInfoMapper {

    @Select("SELECT COLUMN_NAME as column_name,COLUMN_TYPE as column_type FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = 'mall' AND TABLE_NAME = #{tableName}; ")
    @ResultType(ColumnInfo.class)
    List<ColumnInfo> tableColumnInfo(String tableName);

    @Select("select table_name as column_name from information_schema.tables where table_schema='mall' ")
    @ResultType(ColumnInfo.class)
    List<ColumnInfo> tableNames();


}
