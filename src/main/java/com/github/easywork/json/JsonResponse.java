package com.github.easywork.json;


/**
 * @Author lgs
 * @Date 15-5-11 上午11:06
 */
public class JsonResponse {

    //编码
    protected int code;
    //返回数据
    protected Object data;
    //信息
    protected String msg;

    public JsonResponse() {
    }

    public JsonResponse(Object data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public JsonResponse(int code, Object data, String msg) {
        this(data, msg);
        this.code = code;
    }

    public static JsonResponse success() {
        return success(null);
    }

    public static JsonResponse success(Object data) {
        return new JsonResponse(JsonResponseCode.成功.code,data, null);
    }

    public static JsonResponse failure(String msg) {
        return failure(JsonResponseCode.失败.code, msg);
    }

    public static JsonResponse failure(int code, String msg) {
        return new JsonResponse(code, null, msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
