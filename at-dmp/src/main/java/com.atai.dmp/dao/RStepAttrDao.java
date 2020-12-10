package com.atai.dmp.dao;

import com.atai.dmp.entity.RDatabaseEntity;
import com.atai.dmp.entity.RStepAttributeEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface RStepAttrDao extends CrudRepository<RStepAttributeEntity,RStepAttributeEntity.RStepAttributeEntityPK>, JpaSpecificationExecutor<RStepAttributeEntity> {
}
