package com.dhc.app.api.logic.administrator.service;

import com.dhc.app.api.logic.administrator.dao.administrator.po.Administrator;
import com.dhc.app.api.logic.administrator.service.model.request.AdministratorRequestDTO;

public interface AdministratorUpdateService {

    Administrator create(AdministratorRequestDTO.Create requestDTO);

}
