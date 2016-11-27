package com.github.easywork.http;

import com.github.easywork.domain.page.PageResult;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Created by user on 2016/11/10.
 */
@Data
@AllArgsConstructor
public class HttpDataGridPageResponse<T> {

    //返回数据
    protected List<T> rows;

    protected long total;

    public HttpDataGridPageResponse() {

    }

    public static <T> HttpDataGridPageResponse<T> success(PageResult<T> page) {
        return new HttpDataGridPageResponse(page.getData(), page.getTotal());
    }

    public static <T> HttpDataGridPageResponse<T> success(List<T> rows, long total) {
        return new HttpDataGridPageResponse(rows, total);
    }

}
