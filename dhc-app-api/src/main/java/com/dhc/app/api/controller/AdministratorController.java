package com.dhc.app.api.controller;

import com.dhc.app.api.action.administrator.AdministratorQueryAction;
import com.dhc.app.api.action.administrator.model.response.AdministratorAccessTokenVO;
import com.dhc.app.api.service.administrator.dao.po.Administrator;
import com.dhc.app.api.service.administrator.service.AdministratorQueryService;
import com.dhc.app.api.service.administrator.service.AdministratorUpdateService;
import com.dhc.app.api.service.administrator.service.model.request.AdministratorRequestDTO;
import com.dhc.app.api.service.common.context.ApiContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(ApiContext.ADMIN_API + "/administrators")
@Tag(name = "管理员")
public class AdministratorController {

    @Autowired
    private AdministratorUpdateService administratorUpdateService;

    @Autowired
    private AdministratorQueryService administratorQueryService;

    @Autowired
    private AdministratorQueryAction administratorQueryAction;

    @Operation(summary = "管理员_查询详情")
    @GetMapping(value = "", params = "id")
    public Object findAdministrator(@RequestParam("id") Long id) {
        return administratorQueryService.findOneById(id);
    }

    // @Valid 可以是@Size等字段限制生效，只能用在这里，用在create方法中不生效
    @Operation(summary = "管理员_创建")
    @PostMapping("")
    public Object createAdministrator(@Valid @RequestBody AdministratorRequestDTO.Create requestDTO) {
        Administrator model = administratorUpdateService.create(requestDTO);
        return model.getId();
    }

    @Operation(summary = "管理员_更新")
    @PutMapping("")
    public Object updateAdministrator(@Valid @RequestBody AdministratorRequestDTO.Update requestDTO) {
        administratorUpdateService.update(requestDTO.getId(), requestDTO);
        return Optional.empty();
    }

    @Operation(summary = "管理员_删除")
    @DeleteMapping(value = "", params = {"id"})
    public Object deleteAdministrator(@RequestParam("id") Long id) {
        administratorUpdateService.delete(id);
        return Optional.empty();
    }

    @Operation(summary = "管理员_登录")
    @PostMapping("/login")
    public Object login(@Valid @RequestBody AdministratorRequestDTO.Login requestDTO) {
        return administratorQueryAction.login(requestDTO);
    }

}
