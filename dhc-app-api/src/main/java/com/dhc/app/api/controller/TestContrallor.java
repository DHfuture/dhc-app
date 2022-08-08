package com.dhc.app.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestContrallor {

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

//        return a;
    }

}
