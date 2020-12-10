package com.atai.dmp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DmpApplication.class)
public class DmpApplicationTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void main() {

        Query query = entityManager.createQuery("select A from DataelementEntity A  left join DataelementgroupmappingEntity B on A.id=B.dataelementid " +
                "where 1=1 and B.dataelementid in " +
                "('92e64cdb-8eb0-4fe8-a1c0-034bd99f408c')");
        List resultList = query.getResultList();
        resultList.forEach(System.out::println);
    }

    @Test
    public void mainCast() {

        Query query = entityManager.createQuery("select A,B.dataelementclassifyid from DataelementEntity A  left join DataelementgroupmappingEntity B on A.id=B.dataelementid " +
                "where 1=1 and B.dataelementid in " +
                "('92e64cdb-8eb0-4fe8-a1c0-034bd99f408c')");
        List resultList = query.getResultList();
        resultList.forEach(System.out::println);
    }

    @Test
    public void mainCast2() {

        Query query = entityManager.createQuery("select new com.atai.dmp.bean.CastBean(A,B.dataelementclassifyid) from DataelementEntity A  left join DataelementgroupmappingEntity B on A.id=B.dataelementid " +
                "where 1=1 and B.dataelementid in " +
                "('92e64cdb-8eb0-4fe8-a1c0-034bd99f408c')");
        List resultList = query.getResultList();
        resultList.forEach(System.out::println);
    }

    @Test
    public void mainCastMap() {

        Query query = entityManager.createQuery("select new map(A.id as id,B.dataelementclassifyid as dataelementclassifyid) from DataelementEntity A  left join DataelementgroupmappingEntity B on A.id=B.dataelementid " +
                "where 1=1 and B.dataelementid in " +
                "('92e64cdb-8eb0-4fe8-a1c0-034bd99f408c')");
        List resultList = query.getResultList();
        resultList.forEach(System.out::println);
    }
    @Test
    public void mainCastMap3() {

        Query query = entityManager.createQuery("from DataelementEntity A  left join DataelementgroupmappingEntity B on A.id=B.dataelementid " +
                "where 1=1 and B.dataelementid in " +
                "('92e64cdb-8eb0-4fe8-a1c0-034bd99f408c')");
        List resultList = query.getResultList();
        resultList.forEach(System.out::println);
    }
}