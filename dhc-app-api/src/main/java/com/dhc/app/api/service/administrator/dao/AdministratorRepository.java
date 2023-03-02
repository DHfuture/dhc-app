package com.dhc.app.api.service.administrator.dao;

import com.dhc.app.api.service.administrator.dao.po.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

//使用@EnableJpaRepositories后，就不需要@Repository
//@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
}
