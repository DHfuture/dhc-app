package com.dhc.app.api.service.administrator.service.impl;

import com.dhc.app.api.service.administrator.dao.AdministratorRepository;
import com.dhc.app.api.service.administrator.dao.po.Administrator;
import com.dhc.app.api.service.administrator.service.AdministratorUpdateService;
import com.dhc.app.api.service.administrator.service.model.request.AdministratorRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class AdministratorUpdateServiceImpl implements AdministratorUpdateService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public Administrator create(AdministratorRequestDTO.Create requestDTO) {
        Administrator model = mapToModel(requestDTO);
        try {
            administratorRepository.save(model);

        } catch (Exception e) {
            throw e;
        }
        return model;
    }

    @Override
    public void update(Long id, AdministratorRequestDTO.Update requestDTO) {
        Administrator model = administratorRepository.findById(id).orElse(null);
        if (model == null) {
            throw new RuntimeException("账号不存在");
        }
        setUpdateModel(model, requestDTO);
        administratorRepository.save(model);
    }

    @Override
    public void delete(Long id) {
        if (!administratorRepository.existsById(id)) {
            throw new RuntimeException("账号不存在");
        }
        administratorRepository.deleteById(id);
    }

    private Administrator mapToModel(AdministratorRequestDTO.Common requestDTO) {
        Administrator model = new Administrator();
        model.setLonginName(requestDTO.getLonginName());
        model.setPassword(requestDTO.getPassword());
        model.setNickname(requestDTO.getNickname());
        return model;
    }

    private void setUpdateModel(Administrator model, AdministratorRequestDTO.Update requestDTO) {
        if (requestDTO.getLonginName() != null) {
            model.setLonginName(requestDTO.getLonginName());
        }
        if (requestDTO.getPassword() != null) {
            model.setPassword(requestDTO.getPassword());
        }
        if (requestDTO.getNickname() != null) {
            model.setNickname(requestDTO.getNickname());
        }
    }

}
