package com.github.easywork.json;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Author lgs
 * @Date 15-12-9 上午11:41
 */
@Data
@AllArgsConstructor
public class JsonPageResponse<T> {

    //编码
    protected int code = JsonResponseCode.成功.code;
    //返回数据
    protected List<T> data;
    //信息
    protected String msg;

    protected long total;

    public JsonPageResponse() {

    }

    public static <T> JsonPageResponse<T> success(List<T> rows, long total) {
        return new JsonPageResponse(JsonResponseCode.成功.code, rows, null, total);
    }

    public static JsonPageResponse fail(String msg) {
        return new JsonPageResponse(JsonResponseCode.失败.code, null, msg,0);
    }

    public boolean isSuccess() {
        return JsonResponseCode.成功.code == this.code;
    }
}
