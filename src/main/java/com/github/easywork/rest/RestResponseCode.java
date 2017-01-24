package com.github.easywork.rest;

/**
 * Created by lgs on 16-5-31.
 */
public enum RestResponseCode {

    成功(200),
    /**
     *业务处理失败
     */
    业务异常(551),
    /**
     *重复提交
     */
    重复提交(552);
    public final int code;

    RestResponseCode(int code) {
        this.code = code;
    }

}
