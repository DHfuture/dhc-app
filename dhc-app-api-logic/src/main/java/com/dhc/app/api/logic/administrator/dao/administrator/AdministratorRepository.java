package com.dhc.app.api.logic.administrator.dao.administrator;

import com.dhc.app.api.logic.administrator.dao.administrator.po.Administrator;
import org.springframework.data.repository.CrudRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
}
