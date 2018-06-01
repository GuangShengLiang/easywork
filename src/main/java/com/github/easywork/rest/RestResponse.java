package com.github.easywork.rest;

import lombok.Data;

@Data
public class RestResponse<T extends Object> {

    //返回数据
    protected T data;

    public RestResponse() {
    }

    public RestResponse(T data, String msg) {
        this.data = data;

    }


    public static <T> RestResponse<T> success() {
        return success(null);
    }

    public static <T> RestResponse<T> success(T data) {
        return new RestResponse(data, null);
    }

}
