package com.example.springbootjpa.componts;

public class R<T> {

    private Integer code;
    private String message;
    private T data;

    public static<T> R SUCCESS(T t){
        R r = new R(StatusEnum.SUCCESS.getCode(), StatusEnum.SUCCESS.getMessage());
        r.setData(t);
        return r;
    }

    public static<T> R FAILED(T t){
        R r = new R(StatusEnum.FAILED.getCode(), StatusEnum.FAILED.getMessage());
        r.setData(t);
        return r;
    }


    public R(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public R() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
