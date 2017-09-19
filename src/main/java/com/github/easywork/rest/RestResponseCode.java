package com.github.easywork.rest;

import org.springframework.http.HttpStatus;

public enum RestResponseCode {

    成功(HttpStatus.OK.value()),
    已创建(HttpStatus.CREATED.value()),
    未登录(HttpStatus.UNAUTHORIZED.value()),
    未授权(HttpStatus.FORBIDDEN.value()),
    请求量太多(HttpStatus.TOO_MANY_REQUESTS.value()),
    业务异常(1000);

    public final int code;

    RestResponseCode(int code) {
        this.code = code;
    }

}
