package com.github.base.json;

import com.sun.deploy.util.ArrayUtil;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author lgs
 * @Date 15-5-11 上午11:06
 */
@Data
public class JsonResponse {

    enum Status {
        成功("ok"), 失败("fail"), 权限不够("auth");
        final String code;

        Status(String code) {
            this.code = code;
        }
    }

    //状态
    private String status = Status.成功.code;
    //代码
    private String code;
    //返回数据
    private Object data;

    //信息
    private String msg;
    //详细错误信息
    private List<ErrorMessage> errMsg = new LinkedList<ErrorMessage>();

    public JsonResponse() {
    }

    public static JsonResponse success(Object data, String msg) {
        JsonResponse rst = new JsonResponse();
        rst.setMsg(msg);
        rst.setData(data);
        return rst;
    }

    public static JsonResponse success(Object data) {
        JsonResponse rst = new JsonResponse();
        rst.setData(data);
        return rst;
    }

    public static JsonResponse success() {
        JsonResponse rst = new JsonResponse();
        return rst;
    }

    public static JsonResponse fail(Object data,String... msgs) {
        JsonResponse rst = new JsonResponse();
        rst.setStatus(Status.失败.code);
        rst.setData(data);
        injectErrorMsgs(rst,msgs);
        return rst;
    }
    public static JsonResponse fail(String... msgs) {
        JsonResponse rst = new JsonResponse();
        rst.setStatus(Status.失败.code);
        injectErrorMsgs(rst,msgs);
        return rst;
    }
    private static void injectErrorMsgs(JsonResponse rst ,String... msgs){
        if (msgs == null || msgs.length == 0){
            return;
        }
        rst.setMsg(msgs[0]);
        for (String msg : msgs) {
            ErrorMessage errorMessage = new ErrorMessage("", msg);
            rst.errMsg.add(errorMessage);
        }
    }
}
