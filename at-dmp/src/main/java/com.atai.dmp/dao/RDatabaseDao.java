package com.atai.dmp.dao;

import com.atai.dmp.entity.DataelementEntity;
import com.atai.dmp.entity.RDatabaseEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface RDatabaseDao extends CrudRepository<RDatabaseEntity,String>, JpaSpecificationExecutor<RDatabaseEntity> {
}
