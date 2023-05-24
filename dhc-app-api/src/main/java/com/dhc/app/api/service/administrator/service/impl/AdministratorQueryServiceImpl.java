package com.dhc.app.api.service.administrator.service.impl;

import com.dhc.app.api.service.administrator.LoginAdministrator;
import com.dhc.app.api.service.administrator.dao.AdministratorRepository;
import com.dhc.app.api.service.administrator.dao.po.Administrator;
import com.dhc.app.api.service.administrator.service.AdministratorQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @Author donghongchen
 * @create 2023/3/2 14:59
 * @Description:
 */
@Service
public class AdministratorQueryServiceImpl implements AdministratorQueryService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public Optional<Administrator> findOneById(@NotNull Long id) {
        Optional<Administrator> model = administratorRepository.findById(id);
        return model;
    }

    @Override
    public Optional<Administrator> findOneByLoginName(String loginName) {
        return Optional.of(administratorRepository.findByLoginName(loginName));
    }
}
