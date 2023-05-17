package com.dhc.app.api.controller;

import com.dhc.app.api.service.common.context.ApiContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author donghongchen
 * @create 2023/5/15 14:23
 * @Description:
 */
@RestController
@RequestMapping(ApiContext.ADMIN_API + "/test")
@Tag(name = "test")
public class TestController1 {

    @Operation(summary = "test1")
    @GetMapping(value = "")
    public Object findAdministrator() {
        return "hello dhc";
    }


}
