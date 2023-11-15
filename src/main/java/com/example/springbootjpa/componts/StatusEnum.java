package com.example.springbootjpa.componts;

public enum StatusEnum {


    SUCCESS(Compont.SUCCESS_CODE,Compont.SUCEESS_MESSAGE),
    FAILED(Compont.FAILED_CODE,Compont.FAILED_MESSAGE);


    private Integer code;
    private String message;

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

    StatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
