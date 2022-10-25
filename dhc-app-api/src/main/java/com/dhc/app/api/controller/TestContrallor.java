package com.dhc.app.api.controller;

import com.dhc.app.api.service.administrator.service.AdministratorUpdateService;
import com.dhc.app.api.service.administrator.service.model.request.AdministratorRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TestContrallor {

    @Autowired
    private AdministratorUpdateService administratorUpdateService;

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

    @PostMapping("/create/administrator")
    public Object createAdministrator() {
        AdministratorRequestDTO.Create create = new AdministratorRequestDTO.Create();
        administratorUpdateService.create(create);
        return Optional.empty();
    }

}
