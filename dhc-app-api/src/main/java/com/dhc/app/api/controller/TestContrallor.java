package com.dhc.app.api.controller;

import com.dhc.app.api.service.administrator.dao.po.Administrator;
import com.dhc.app.api.service.administrator.service.AdministratorQueryService;
import com.dhc.app.api.service.administrator.service.AdministratorUpdateService;
import com.dhc.app.api.service.administrator.service.model.request.AdministratorRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TestContrallor {

    @Autowired
    private AdministratorUpdateService administratorUpdateService;

    @Autowired
    private AdministratorQueryService administratorQueryService;

    @GetMapping("/a")
    public Object test1() {
        List<String> a = new ArrayList<>();
        a.add("aa");
        a.add("bb");
        return a;
    }

    @GetMapping("/b")
    public Object test2() throws Exception {
        List<String> a = new ArrayList<>();
        a.add("aa");
        a.add("bb");
        throw new Exception("报错啦");
    }

    // @Valid 可以是@Size等字段限制生效，只能用在这里，用在create方法中不生效
    @PostMapping("/administrator")
    public Object createAdministrator(@Valid @RequestBody AdministratorRequestDTO.Create requestDTO) {
        Administrator model = administratorUpdateService.create(requestDTO);
        return model.getId();
    }

    @PutMapping("/administrator")
    public Object updateAdministrator(@Valid @RequestBody AdministratorRequestDTO.Update requestDTO) {
        administratorUpdateService.update(requestDTO.getId(), requestDTO);
        return Optional.empty();
    }

    @DeleteMapping(value = "/administrator", params = {"id"})
    public Object deleteAdministrator(@RequestParam("id") Long id) {
        administratorUpdateService.delete(id);
        return Optional.empty();
    }

    @GetMapping(value = "/administrator", params = "id")
    public Object findAdministrator(@RequestParam("id") Long id) {
        return administratorQueryService.findOneById(id);
    }

}
