package com.dhc.app.api.utils.response;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class WebResponseException extends WebAbstractResponse {

    private static final Logger logger = LoggerFactory.getLogger(WebResponseException.class);

    /**
     * 所有异常进行包装
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Throwable.class)
    public WebAPIResponse<?> exceptionHandler(Exception e) {
//        return WebAPIResponse.fail(0, e.getMessage(), null);


        if (!(e instanceof HttpMediaTypeNotSupportedException)) {
            logger.error("未知异常失败", e);
        }

        return WebAPIResponse.fail(0, "系统繁忙，请稍后再试" + e.getMessage());

    }

}
