package com.atai.dmp.entity;

import com.atai.dmp.DmpApplication;
import com.atai.dmp.dao.RDatabaseDao;
import com.atai.dmp.dao.RStepAttrDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import java.util.List;
import java.util.function.Consumer;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DmpApplication.class)
public class RDatabaseEntityTest {

    @Autowired
    RDatabaseDao rDatabaseDao;

    @Autowired
    RStepAttrDao rStepAttrDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Before
    public void setUp() throws Exception {
//        entityManager.createNativeQuery()
    }


    @Transactional
    @Test
    public void getDataelementEntity() {
        Query query = entityManager.createQuery("from DataelementEntity where id = '1'");
        List resultList = query.getResultList();
        resultList.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
    }

    @Transactional
    @Test
    public void getDatabaseName() {
        Query query = entityManager.createQuery("from RDatabaseEntity where database_name = '1sefsefasf'");
        List resultList = query.getResultList();
        resultList.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
    }

    @Transactional
    @Test
    public void getDatabaseNameJPa() {
        rDatabaseDao.findAll(new Specification<RDatabaseEntity>() {
            @Override
            public Predicate toPredicate(Root<RDatabaseEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        });
    }
    @Transactional
    @Test
    public void getDatabaseName33() {
        Query query = entityManager.createQuery("from RStepAttributeEntity where valueStr = 'sef'");
        List resultList = query.getResultList();
        resultList.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
    }

    @Transactional
    @Test
    public void getDatabasNameJPa() {
        long count = rStepAttrDao.count(new Specification<RStepAttributeEntity>() {
            @Override
            public Predicate toPredicate(Root<RStepAttributeEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate clusterNameEqual = criteriaBuilder.equal(root.get("valueStr"), "sef");
                Predicate codeEqual = criteriaBuilder.equal(root.get("code"), "source_configuration_name");
                Predicate codeEqual1 = criteriaBuilder.equal(root.get("code"), "cluster_name");
                Predicate codeOr = criteriaBuilder.or(codeEqual, codeEqual1);
                return criteriaBuilder.and(clusterNameEqual, codeOr);
            }
        });
        System.out.println(count);
    }



}