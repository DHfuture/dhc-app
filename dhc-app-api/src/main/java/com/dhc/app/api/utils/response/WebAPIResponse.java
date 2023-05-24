package com.dhc.app.api.utils.response;

public class WebAPIResponse<T>{

    private boolean success;

    private int code;

    private String message;

    private T data;

    public WebAPIResponse() {
    }

    public WebAPIResponse(boolean success, int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public WebAPIResponse(T data) {
        this.success = true;
        this.code = 0;
        this.message = "success";
        this.data = data;
    }

    public WebAPIResponse(int code, String message) {
        this.success = true;
        this.code = code;
        this.message = message;
    }

    public static <T> WebAPIResponse<T> success(T data) {
        return new WebAPIResponse<>(data);
    }

    public static <T> WebAPIResponse<T> fail(int code, T data) {
        return new WebAPIResponse<>(false, code, "未知错误", data);
    }

    public static <T> WebAPIResponse<T> fail(int code, String message, T data) {
        return new WebAPIResponse<>(false, code, message, data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
