package com.dhc.app.api.service.administrator.dao;

import com.dhc.app.api.service.administrator.dao.po.Administrator;
import com.dhc.app.api.utils.repository.BaseRepository;

//使用@EnableJpaRepositories后，就不需要@Repository
//@Repository
public interface AdministratorRepository extends BaseRepository<Administrator, Long> {

    Administrator findByLoginName(String loginName);

}
