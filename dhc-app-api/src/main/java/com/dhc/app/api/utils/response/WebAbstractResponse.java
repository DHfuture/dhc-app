package com.dhc.app.api.utils.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

public abstract class WebAbstractResponse implements ResponseBodyAdvice<Object> {

    /**
     * 判断是否执行beforeBodyWrite
     * 返回true，则下面的beforeBodyWrite被调用
     * @param returnType 方法返回类型
     * @param converterType 参数类型转换
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        /*
        * 过滤String类型的返回值，String类型返回值不进行包装
        * 返回值类型为字符串时，转化器converterType的类型为 StringHttpMessageConverter
        * 因此可以通过判断converterType类型是否继承自 AbstractJackson2HttpMessageConverter 进而过滤String类型的返回值
        */
        return AbstractJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
    }

    /**
     * 对response方法进行具体的处理
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
//        if (body instanceof WebAPIResponse) {
//            return body;
//        }
//        return WebAPIResponse.success(body);

        if (!(body instanceof ResponseEntity) &&
                !(body instanceof WebAPIResponse)) {
            return WebAPIResponse.success(body);
        }

        return body;


    }
}
