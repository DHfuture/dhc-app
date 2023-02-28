package com.dhc.app.api.service.administrator.dao;

import com.dhc.app.api.service.administrator.dao.po.Administrator;
import org.springframework.data.repository.CrudRepository;

public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
}
