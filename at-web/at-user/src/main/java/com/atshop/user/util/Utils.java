package com.atshop.user.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.commons.io.FileUtils;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.hibernate.persister.walking.spi.AttributeDefinition;
import org.hibernate.transform.Transformers;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Utils {
    //   获取容器托管的EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    public void getEntityClass() {
//通过EntityManager获取factory
        EntityManagerFactory entityManagerFactory = entityManager.getEntityManagerFactory();
        SessionFactoryImpl sessionFactory = (SessionFactoryImpl) entityManagerFactory.unwrap(SessionFactory.class);
        Map<String, EntityPersister> persisterMap = sessionFactory.getEntityPersisters();
        for (Map.Entry<String, EntityPersister> entity : persisterMap.entrySet()) {
            Class targetClass = entity.getValue().getMappedClass();
            SingleTableEntityPersister persister = (SingleTableEntityPersister) entity.getValue();
            Iterable<AttributeDefinition> attributes = persister.getAttributes();
            String entityName = targetClass.getSimpleName();//Entity的名称
            String tableName = persister.getTableName();//Entity对应的表的英文名

            System.out.println("类名：" + entityName + " => 表名：" + tableName);

            //属性
            for (AttributeDefinition attr : attributes) {
                String propertyName = attr.getName(); //在entity中的属性名称
                String[] columnName = persister.getPropertyColumnNames(propertyName); //对应数据库表中的字段名
                String type = "";
                PropertyDescriptor targetPd = BeanUtils.getPropertyDescriptor(targetClass, propertyName);
                if (targetPd != null) {
                    type = targetPd.getPropertyType().getSimpleName();
                }
                System.out.println("属性名：" + propertyName + " => 类型：" + type + " => 数据库字段名：" + columnName[0]);
            }

        }
    }
    public void getEntityClassData() {
//通过EntityManager获取factory
        EntityManagerFactory entityManagerFactory = entityManager.getEntityManagerFactory();
        SessionFactoryImpl sessionFactory = (SessionFactoryImpl) entityManagerFactory.unwrap(SessionFactory.class);
        Map<String, EntityPersister> persisterMap = sessionFactory.getEntityPersisters();
        Map<String,List> res=new HashMap<>();
        for (Map.Entry<String, EntityPersister> entity : persisterMap.entrySet()) {
            Class targetClass = entity.getValue().getMappedClass();
            SingleTableEntityPersister persister = (SingleTableEntityPersister) entity.getValue();
            String entityName = targetClass.getSimpleName();//Entity的名称

            Query query = entityManager.createQuery("from " + entityName);
            List resultList = query.getResultList();
            res.put(entityName, resultList);
            try {
                System.out.println(new ObjectMapper().writeValueAsString(resultList));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        try {
            FileUtils.write(new File("out.json"),new ObjectMapper().writeValueAsString(res), StandardCharsets.UTF_8 );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
