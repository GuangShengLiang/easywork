package com.github.easywork.http;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Author lgs
 * @Date 15-12-9 上午11:41
 */
@Data
@AllArgsConstructor
public class HttpJsonPageResponse<T> {

    //返回数据
    protected List<T> data;

    protected long total;

    public HttpJsonPageResponse() {

    }

    public static <T> HttpJsonPageResponse<T> success(List<T> rows, long total) {
        return new HttpJsonPageResponse(rows, total);
    }
}
