package com.github.easywork.exception;

import com.github.easywork.rest.RestCodeEnum;

public class BaseException extends RuntimeException {
    //http status
    protected int httpStatus = RestCodeEnum.业务异常.code;

    protected int code;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(int httpStatus, int code, String message) {
        this(code, message);
        this.httpStatus = httpStatus;
    }

    public BaseException() {
        super();
    }

    public int getCode() {
        return this.code;
    }

    public int getHttpStatus(){
        return httpStatus;
    }
}
