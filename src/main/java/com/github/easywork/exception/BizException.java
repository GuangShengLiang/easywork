package com.github.easywork.exception;

public class BizException extends BaseException {

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(int code, String message) {
        super(code, message);
    }

    public BizException(int httpStatus, int code, String message) {
        super(httpStatus, code, message);
    }
}
