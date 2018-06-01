package com.github.easywork.json;

public enum JsonResponseCode {
    成功(0), 失败(1),
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
