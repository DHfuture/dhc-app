package com.dhc.app.api.service.administrator.service.impl;

import com.dhc.app.api.service.administrator.dao.AdministratorRepository;
import com.dhc.app.api.service.administrator.dao.po.Administrator;
import com.dhc.app.api.service.administrator.service.AdministratorUpdateService;
import com.dhc.app.api.service.administrator.service.model.request.AdministratorRequestDTO;
import com.dhc.app.api.utils.AdministratorPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class AdministratorUpdateServiceImpl implements AdministratorUpdateService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private AdministratorPasswordEncoder administratorPasswordEncoder;

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
        model.setLoginName(requestDTO.getLoginName());
        model.setPassword(administratorPasswordEncoder.encode(requestDTO.getPassword()));
        model.setNickname(requestDTO.getNickname());
        model.setAuthority(requestDTO.getAuthority());
        return model;
    }

    private void setUpdateModel(Administrator model, AdministratorRequestDTO.Update requestDTO) {
        if (requestDTO.getLoginName() != null) {
            model.setLoginName(requestDTO.getLoginName());
        }
        if (requestDTO.getPassword() != null) {
            model.setPassword(administratorPasswordEncoder.encode(requestDTO.getPassword()));
        }
        if (requestDTO.getNickname() != null) {
            model.setNickname(requestDTO.getNickname());
        }
        if (requestDTO.getAuthority() != null) {
            model.setAuthority(requestDTO.getAuthority());
        }
    }

}
