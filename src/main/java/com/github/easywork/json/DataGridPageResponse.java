package com.github.easywork.json;

import com.github.easywork.domain.page.PageResult;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by user on 2016/11/10.
 */
@Data
@AllArgsConstructor
public class DataGridPageResponse<T> {

    //编码
    protected int code = JsonResponseCode.成功.code;
    //返回数据
    protected List<T> rows;
    //信息
    protected String msg;

    protected long total;

    public DataGridPageResponse() {

    }
    public static <T> JsonPageResponse<T> success(PageResult<T> page) {
        return new JsonPageResponse(JsonResponseCode.成功.code, page.getData(), null, page.getTotal());
    }
    public static <T> JsonPageResponse<T> success(List<T> rows, long total) {
        return new JsonPageResponse(JsonResponseCode.成功.code, rows, null, total);
    }

    public static JsonPageResponse fail(String msg) {
        return new JsonPageResponse(JsonResponseCode.失败.code, null, msg, 0);
    }

    public boolean isSuccess() {
        return JsonResponseCode.成功.code == this.code;
    }
}
