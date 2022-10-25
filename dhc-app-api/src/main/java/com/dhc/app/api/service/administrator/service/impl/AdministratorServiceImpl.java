package com.dhc.app.api.service.administrator.service.impl;

import com.dhc.app.api.service.administrator.dao.AdministratorRepository;
import com.dhc.app.api.service.administrator.dao.po.Administrator;
import com.dhc.app.api.service.administrator.service.AdministratorUpdateService;
import com.dhc.app.api.service.administrator.service.model.request.AdministratorRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorUpdateService {

    private AdministratorRepository administratorRepository;

    @Autowired
    public void setAdministratorRepository(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public Administrator create(AdministratorRequestDTO.Create requestDTO) {
        Administrator model = mapToModel(requestDTO);
        administratorRepository.save(model);
        return null;
    }

    private Administrator mapToModel(AdministratorRequestDTO.Common requestDTO) {
        Administrator model = new Administrator();
        model.setLonginName(requestDTO.getLonginName());
        model.setPassword(requestDTO.getPassword());
        model.setNickname(requestDTO.getNickname());
        return model;

    }
}
