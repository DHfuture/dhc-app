package com.dhc.app.api.response;


import org.springframework.web.bind.annotation.ExceptionHandler;

public class WebResponseException extends WebAbstractResponseAdapter {

    /**
     * 所有异常进行包装
     * @param e
     * @return
     */
    @ExceptionHandler(value = Throwable.class)
    public WebAPIResponse<?> exceptionHandler(Exception e) {
        return WebAPIResponse.fail(0, e.getMessage(), null);
    }

}
