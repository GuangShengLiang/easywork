package com.github.easywork.json;

import lombok.Data;

/**
 * @Author lgs
 * @Date 15-5-11 上午11:06
 */
@Data
public class JsonResponse<T extends Object> {

    public final static JsonResponse SUCCESS = new JsonResponse(JsonResponseCode.成功.code, null, null);
    //编码
    protected int code;
    //返回数据
    protected T data;
    //信息
    protected String msg;

    public JsonResponse() {
    }

    public JsonResponse(T data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public JsonResponse(int code, T data, String msg) {
        this(data, msg);
        this.code = code;
    }

    public static <T> JsonResponse<T> success(T data) {
        return new JsonResponse(JsonResponseCode.成功.code, data, null);
    }

    public static <T> JsonResponse<T> fail(String msg) {
        return fail(JsonResponseCode.失败.code, msg);
    }

    public static <T> JsonResponse<T> fail(int code, String msg) {
        return new JsonResponse(code, null, msg);
    }

}
