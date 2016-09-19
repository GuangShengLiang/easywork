package com.github.easywork.exception;


import com.github.easywork.json.JsonResponseCode;

/**
 * @Author lgs
 * @Date 15-7-16 下午5:19
 */
public class Errors {

    private int code = JsonResponseCode.失败.code;

    private Object[] args;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
