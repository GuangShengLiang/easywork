package com.github.easywork.rest;

import org.springframework.http.HttpStatus;

/**
 * Created by lgs on 16-5-31.
 */
public enum RestResponseCode {

    成功(200),
    未登录(HttpStatus.UNAUTHORIZED.value()),
    未授权(HttpStatus.FORBIDDEN.value()),
    请求量太多(HttpStatus.TOO_MANY_REQUESTS.value()),
    已删除(HttpStatus.GONE.value()),
    业务异常(551),
    已创建(HttpStatus.CREATED.value());
    public final int code;

    RestResponseCode(int code) {
        this.code = code;
    }

}
