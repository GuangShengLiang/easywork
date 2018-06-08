package com.github.easywork.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse {
    //错误码
    protected int code;
    //信息
    protected String msg;

    public static RestResponse fail(int code, String msg) {
        return new RestResponse(code, msg);
    }

    public static RestResponse fail(RestCodeEnum rest) {
        return new RestResponse(rest.code, rest.name());
    }
    public static boolean isBizFail(int httpStatus) {
        if (httpStatus >= RestCodeEnum.业务异常.code) {
            return true;
        }
        return false;
    }
}
