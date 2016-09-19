package com.github.easywork.json;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author lgs
 * @Date 15-12-9 上午11:41
 */
public class JsonPageResponse extends JsonResponse {

    private long total;
    public JsonPageResponse(){

    }
    public JsonPageResponse(int code,Object rows, String msg){
        super(code, rows,msg);
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
        return new JsonPageResponse(-1,Lists.newLinkedList(),msg);
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
