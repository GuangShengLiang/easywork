package com.github.easywork.http;

/**
 * Created by lgs on 16-5-31.
 */
public enum HttpResponseCode {
    失败(600),
    失败并提示(601),
    数据已存在(602);
    public final Integer code;

    HttpResponseCode(Integer code) {
        this.code = code;
    }


}
