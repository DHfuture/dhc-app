package com.dhc.app.api.service.administrator.dao;

import com.dhc.app.api.service.administrator.dao.po.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
}
