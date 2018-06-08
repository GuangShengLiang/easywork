package com.github.easywork.domain.error;


import com.github.easywork.rest.RestCodeEnum;
import lombok.Data;

@Data
public class Errors {

    private int code = RestCodeEnum.业务异常.code;

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
