package com.atshop.user.util;

import com.atshop.user.UserApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class UtilsTest {

    @Autowired
    Utils utils;

    @Test
    public void getEntityClass() {
        utils.getEntityClass();
    }  @Test
    public void getEntityClassData() {
        utils.getEntityClassData();
    }

}