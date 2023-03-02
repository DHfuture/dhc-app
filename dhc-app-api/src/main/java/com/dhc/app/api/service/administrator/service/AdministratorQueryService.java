package com.dhc.app.api.service.administrator.service;

import com.dhc.app.api.service.administrator.dao.po.Administrator;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @Author donghongchen
 * @create 2023/3/2 14:58
 * @Description:
 */
public interface AdministratorQueryService {

    Optional<Administrator> findOneById(@NotNull Long id);

}
