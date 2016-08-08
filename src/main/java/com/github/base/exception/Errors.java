package com.github.base.exception;


/**
 * @Author lgs
 * @Date 15-7-16 下午5:19
 */
public class Errors {

    private String errorCode;

    private Object[] args;

    private String message;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
