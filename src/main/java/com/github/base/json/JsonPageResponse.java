package com.github.base.json;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @Author lgs
 * @Date 15-12-9 上午11:41
 */
public class JsonPageResponse extends JsonResponse {

    private Long total = 0l;
    public JsonPageResponse(){

    }
    public JsonPageResponse(String status,Object rows, String msg){
        super(status, rows,msg);
    }


    public static <T> JsonPageResponse successPage(List<T> rows,long total) {
        JsonPageResponse response = new JsonPageResponse();
        if (rows == null) {
            response.data =Lists.newLinkedList();
        } else {
            response.data = rows;
        }
        response.total = total;
        return response;

    }
    public static JsonPageResponse failure(String msg){
        return new JsonPageResponse(JsonResponseStatus.失败.code,Lists.newLinkedList(),msg);
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
