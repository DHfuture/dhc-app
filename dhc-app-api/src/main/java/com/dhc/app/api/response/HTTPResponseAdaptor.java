package com.dhc.app.api.response;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * HTTP监控的路径，将返回值进行包装
 * 没有配置 @RestControllerAdvice 就找不到接口，调用时报404
 */
@RestControllerAdvice({"com.dhc.app.api.controller"})
public class HTTPResponseAdaptor extends WebResponseException {

    public HTTPResponseAdaptor() {
        //包装返回值，必须有@RestControllerAdvice注解才能生效
        super();
    }
}
