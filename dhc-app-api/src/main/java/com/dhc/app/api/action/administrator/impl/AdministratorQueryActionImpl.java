package com.dhc.app.api.action.administrator.impl;

import com.dhc.app.api.action.administrator.AdministratorQueryAction;
import com.dhc.app.api.action.administrator.model.response.AdministratorAccessTokenVO;
import com.dhc.app.api.service.administrator.service.AdministratorQueryService;
import com.dhc.app.api.service.administrator.service.model.request.AdministratorRequestDTO;
import com.dhc.app.api.utils.RedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author donghongchen
 * @create 2023/5/18 15:32
 * @Description:
 */
@Service
public class AdministratorQueryActionImpl implements AdministratorQueryAction {

    Logger logger = LoggerFactory.getLogger(AdministratorQueryActionImpl.class);

    @Autowired
    private AdministratorQueryService administratorQueryService;

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public AdministratorAccessTokenVO login(AdministratorRequestDTO.Login requestDTO) {
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(requestDTO.getLoginName(), requestDTO.getPassword());
//        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
//        if (Objects.isNull(authenticate)) {
//            throw new RuntimeException("用户名或密码错误");
//        }
//        //使用userid生成token
//        LoginAdministrator loginUser = (LoginAdministrator) authenticate.getPrincipal();
//        String userId = loginUser.getAdministrator().getId().toString();
//        String jwt = JwtUtil.createJWT(userId);
//        //authenticate存入redis
//        redisCache.setCacheObject("login:" + userId, loginUser);
//        //把token响应给前端
//        HashMap<String, String> map = new HashMap<>();
//        map.put("token", jwt);
        AdministratorAccessTokenVO tokenVO = new AdministratorAccessTokenVO();
//        tokenVO.setAccessToken(jwt);
//        tokenVO.setAdministrator(loginUser.getAdministrator());

        return tokenVO;
    }
}
