package com.dhc.app.api.security;

import com.dhc.app.api.service.administrator.dao.AdministratorRepository;
import com.dhc.app.api.service.administrator.dao.po.Administrator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AdministratorRepository administratorRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrator administrator = administratorRepository.findByLoginName(username);
        if (administrator == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
//        return new LoginAdministrator(administrator);
        return new User(administrator.getLoginName(), administrator.getPassword(), new ArrayList<>());
    }
}
