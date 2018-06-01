package com.github.easywork.rest;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RestPageResponse<T> {

    //返回数据
    protected List<T> data;

    protected long total;

    public RestPageResponse() {

    }

    public static <T> RestPageResponse<T> success(List<T> rows, long total) {
        return new RestPageResponse(rows, total);
    }
}
