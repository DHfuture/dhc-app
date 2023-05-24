package com.dhc.app.api.controller;

import com.dhc.app.api.action.administrator.AdministratorQueryAction;
import com.dhc.app.api.action.administrator.model.response.AdministratorAccessTokenVO;
import com.dhc.app.api.service.administrator.service.model.request.AdministratorRequestDTO;
import com.dhc.app.api.service.common.context.ApiContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author donghongchen
 * @create 2023/5/15 14:23
 * @Description:
 */
@RestController
@RequestMapping(ApiContext.ADMIN_API + "/test")
@Tag(name = "test")
public class TestController1 {

    @Autowired
    private AdministratorQueryAction administratorQueryAction;

    @Operation(summary = "test1")
    @GetMapping(value = "")
    public Object findAdministrator() {
        AdministratorRequestDTO.Login requestDTO = new AdministratorRequestDTO.Login();
        requestDTO.setLoginName("donghongchen");
        requestDTO.setPassword("123456");
        return administratorQueryAction.login(requestDTO);
//        return "hello dhc";
    }

    @Operation(summary = "管理员_登录2")
    @PostMapping("/login2")
    public AdministratorAccessTokenVO login() {
        AdministratorRequestDTO.Login requestDTO = new AdministratorRequestDTO.Login();
        requestDTO.setLoginName("donghongchen");
        requestDTO.setPassword("123456");
        return administratorQueryAction.login(requestDTO);
    }


}
