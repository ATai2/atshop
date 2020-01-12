package com.lee.gmall.manage.service.impl;

import com.lee.gmall.manage.GmallManageServiceApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {GmallManageServiceApplication.class})// 指定启动类
@Slf4j
public class TableInfoServiceImplTest {

    @Autowired
    TableInfoServiceImpl tableInfoServiceImpl;
    @Test
    public void excuteMapperMethod() {
        tableInfoServiceImpl.excuteMapperMethod(null);
    }
}