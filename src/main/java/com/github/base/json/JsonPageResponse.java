package com.github.base.json;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @Author lgs
 * @Date 15-12-9 上午11:41
 */
@Data
public class JsonPageResponse extends JsonResponse {

    private Integer total = 0;

    public JsonPageResponse(String status,Object rows, String msg){
        super(status, rows,msg);
    }

    public static JsonPageResponse success(List<Object> rows) {
        JsonPageResponse response = new JsonPageResponse(JsonResponseStatus.失败.code,null,"");
        if (rows == null) {
            response.data =Lists.newLinkedList();
        } else {
            response.data = rows;
            response.total = rows.size();
        }
        return response;
    }
    public static JsonPageResponse failure(String msg){
        return new JsonPageResponse(JsonResponseStatus.失败.code,Lists.newLinkedList(),msg);
    }
}
