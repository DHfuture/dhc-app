package com.dhc.app.api.action.administrator;

import com.dhc.app.api.action.administrator.model.response.AdministratorAccessTokenVO;
import com.dhc.app.api.service.administrator.service.model.request.AdministratorRequestDTO;

import javax.validation.Valid;

/**
 * @Author donghongchen
 * @create 2023/5/18 15:18
 * @Description:
 */
public interface AdministratorQueryAction {

    AdministratorAccessTokenVO login(@Valid AdministratorRequestDTO.Login requestDTO);
}
