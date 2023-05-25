package com.dhc.app.api.service.administrator.service;

import com.dhc.app.api.action.administrator.model.response.AdministratorAccessTokenVO;
import com.dhc.app.api.service.administrator.dao.AdministratorRepository;
import com.dhc.app.api.service.administrator.dao.po.Administrator;
import com.dhc.app.api.service.administrator.service.model.request.AdministratorRequestDTO;
import com.dhc.app.api.utils.service.impl.BaseServiceImpl;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @Author donghongchen
 * @create 2023/3/2 14:58
 * @Description:
 */
public interface AdministratorQueryService {

    Optional<Administrator> findOneById(@NotNull Long id);

    Optional<Administrator> findOneByLoginName(@NotNull String loginName);
}
