package com.github.easywork.http;

import lombok.Data;

/**
 * @Author lgs
 * @Date 15-5-11 上午11:06
 */
@Data
public class HttpJsonResponse<T extends Object> {

    //返回数据
    protected T data;

    public HttpJsonResponse() {
    }

    public HttpJsonResponse(T data, String msg) {
        this.data = data;

    }


    public static <T> HttpJsonResponse<T> success() {
        return success(null);
    }

    public static <T> HttpJsonResponse<T> success(T data) {
        return new HttpJsonResponse(data, null);
    }

}
