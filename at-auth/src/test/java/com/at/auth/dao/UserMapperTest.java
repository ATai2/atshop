//package com.at.auth.dao;
//
//import com.at.auth.entity.UserDO;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserMapperTest {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Test
//    public void testSelect() {
//        System.out.println(("----- selectAll method test ------"));
//        List<UserDO> userList = userMapper.selectList(null);
//        Assert.assertEquals(5, userList.size());
//        userList.forEach(System.out::println);
//    }
//    @Test
//    public void testInsert() {
//        System.out.println(("----- insert method test ------"));
//
//        UserDO entity = new UserDO();
//        entity.setCreateTime(new Date());
//        entity.setModifiedTime(new Date());
//        entity.setUserName("scott");
//        entity.setPasswd("aaaaaa");
//
//        userMapper.insert(entity);
//    }
//
//}