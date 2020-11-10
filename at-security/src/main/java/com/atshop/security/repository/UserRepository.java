package com.atshop.security.repository;

import com.atshop.security.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaSpecificationExecutor<User>, CrudRepository<User,Long> {
}
