package com.github.easywork.json;

/**
 * Created by lgs on 16-5-31.
 */
public enum JsonResponseCode {
    成功(0), 失败(1), 参数错误(2),
    //登录、权限
    用户未登录(100),
    未授权(150);
    public final int code;

    public String desc;

    JsonResponseCode(int code) {
        this.code = code;
    }

    JsonResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
