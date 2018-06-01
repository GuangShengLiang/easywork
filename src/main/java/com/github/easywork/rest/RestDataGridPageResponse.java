package com.github.easywork.rest;

import com.github.easywork.domain.page.PageResult;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RestDataGridPageResponse<T> {

    //返回数据
    protected List<T> rows;

    protected long total;

    public RestDataGridPageResponse() {

    }

    public static <T> RestDataGridPageResponse<T> success(PageResult<T> page) {
        return new RestDataGridPageResponse(page.getData(), page.getTotal());
    }

    public static <T> RestDataGridPageResponse<T> success(List<T> rows, long total) {
        return new RestDataGridPageResponse(rows, total);
    }

}
