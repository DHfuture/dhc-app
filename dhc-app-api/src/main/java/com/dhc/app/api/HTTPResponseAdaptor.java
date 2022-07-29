package com.dhc.app.api;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * HTTP监控的路径，将返回值进行包装
 * 没有配置 @RestControllerAdvice 就找不到接口，调用时报404
 */
@RestControllerAdvice({"com.dhc.app.api"})
public class HTTPResponseAdaptor {
}
