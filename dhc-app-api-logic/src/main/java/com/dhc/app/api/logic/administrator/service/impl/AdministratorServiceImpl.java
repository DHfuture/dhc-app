package com.dhc.app.api.logic.administrator.service.impl;

import com.dhc.app.api.logic.administrator.dao.administrator.AdministratorRepository;
import com.dhc.app.api.logic.administrator.dao.administrator.po.Administrator;
import com.dhc.app.api.logic.administrator.service.AdministratorUpdateService;
import com.dhc.app.api.logic.administrator.service.model.request.AdministratorRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class AdministratorServiceImpl implements AdministratorUpdateService {

    @Autowired
    private AdministratorRepository administratorRepository;


    @Override
    public Administrator create(AdministratorRequestDTO.Create requestDTO) {
        Administrator model = new Administrator();
        administratorRepository.save(model);
        return null;
    }
}
