package com.dhc.app.api.action.administrator.impl;

import com.dhc.app.api.action.administrator.AdministratorQueryAction;
import com.dhc.app.api.action.administrator.model.response.AdministratorAccessTokenVO;
import com.dhc.app.api.service.administrator.dao.po.Administrator;
import com.dhc.app.api.service.administrator.service.AdministratorQueryService;
import com.dhc.app.api.service.administrator.service.model.request.AdministratorRequestDTO;
import com.dhc.app.api.utils.RedisCache;
import com.dhc.app.api.security.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

/**
 * @Author donghongchen
 * @create 2023/5/18 15:32
 * @Description:
 */
@Service
@RequiredArgsConstructor
public class AdministratorQueryActionImpl implements AdministratorQueryAction {

    Logger logger = LoggerFactory.getLogger(AdministratorQueryActionImpl.class);

    private final AdministratorQueryService administratorQueryService;
    private final AuthenticationManager authenticationManager;
    private final RedisCache redisCache;

    @Override
    public AdministratorAccessTokenVO login(AdministratorRequestDTO.Login requestDTO) {
        // 使用spring security的认证方法
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDTO.getLoginName(), requestDTO.getPassword()));
        } catch (AuthenticationException e) {
            throw new RuntimeException("用户名或密码错误", e);
        }

        Administrator administrator = administratorQueryService.findOneByLoginName(requestDTO.getLoginName())
                .orElseThrow(() -> new RuntimeException("用户名或密码错误"));


        String token = JwtUtil.generateToken(administrator.getId(), administrator.getLoginName());
        // 将token存储
        redisCache.setCacheObject("token:", token);

        AdministratorAccessTokenVO tokenVO = new AdministratorAccessTokenVO();
        tokenVO.setAccessToken(token);
        tokenVO.setAdministrator(administrator);

        return tokenVO;
    }
}
