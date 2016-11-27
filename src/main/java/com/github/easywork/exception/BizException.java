package com.github.easywork.exception;

/**
 * @Author lgs
 * @Date 15-7-17 下午2:58
 */
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

}
