package com.github.easywork.json;

import lombok.Data;

@Data
public class JsonResponse<T extends Object> {

    /**
     * 状态码：成功(0)，失败（非0)
     *
     * @mock 0
     */
    private int code;
    /**
     * 数据
     */
    private T data;
    /**
     * 错误信息
     *
     * @mock ok
     */
    private String msg;

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

    public static <T> JsonResponse<T> success() {
        return success(null);
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
