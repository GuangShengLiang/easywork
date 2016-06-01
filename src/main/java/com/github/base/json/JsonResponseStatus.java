package com.github.base.json;

/**
 * Created by lgs on 16-5-31.
 */
public enum JsonResponseStatus {
    成功("ok"), 失败("fail");
    public final String code;

    JsonResponseStatus(String code) {
        this.code = code;
    }
}
