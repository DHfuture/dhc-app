package com.dhc.app.api.service.administrator.service;

import com.dhc.app.api.action.administrator.model.response.AdministratorAccessTokenVO;
import com.dhc.app.api.service.administrator.dao.po.Administrator;
import com.dhc.app.api.service.administrator.service.model.request.AdministratorRequestDTO;

public interface AdministratorUpdateService {

    Administrator create(AdministratorRequestDTO.Create requestDTO);

    void update(Long id, AdministratorRequestDTO.Update requestDTO);

    void delete(Long id);

}
