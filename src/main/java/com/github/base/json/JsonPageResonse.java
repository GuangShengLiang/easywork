package com.github.base.json;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @Author lgs
 * @Date 15-12-9 上午11:41
 */
@Data
public class JsonPageResonse extends JsonResponse {

    private List<Object> rows;

    private Integer total = 0;

    public static JsonPageResonse successPage(List<Object> rows) {
        JsonPageResonse resonse = new JsonPageResonse();
        resonse.success();
        if (rows == null) {
            resonse.rows = Lists.newArrayList();
        } else {
            resonse.rows = rows;
            resonse.total = rows.size();
        }
        return resonse;
    }
    public static JsonPageResonse failPage(String msg){
        JsonPageResonse resonse = new JsonPageResonse();
        resonse.failure(msg);
        resonse.rows = Lists.newArrayList();
        return resonse;
    }
}
