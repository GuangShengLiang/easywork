package com.github.easywork.rest;

import org.springframework.http.HttpStatus;

public enum RestCodeEnum implements IErrorCode {

    成功(200),
    未登录(HttpStatus.UNAUTHORIZED.value()),
    未授权(HttpStatus.FORBIDDEN.value()),
    请求量太多(HttpStatus.TOO_MANY_REQUESTS.value()),
    已删除(HttpStatus.GONE.value()),
    //600～999号段: 业务异常
    业务异常(600),
    已创建(HttpStatus.CREATED.value());

    public final int code;

    RestCodeEnum(int code) {
        this.code = code;
    }

    public String getMessage(){
        return name();
    }
    public int getCode(){
        return code;
    }
}
