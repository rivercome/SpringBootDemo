package com.example.agreement.Exception;

public class ErrorParamsException extends RuntimeException {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorParamsException(String message){
        super("您在" + message + "填写中缺少信息");
    }
}
