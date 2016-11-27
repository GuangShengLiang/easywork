package com.github.easywork.domain.error;


import com.github.easywork.http.HttpResponseCode;
import com.github.easywork.json.JsonResponseCode;
import lombok.Data;

/**
 * @Author lgs
 * @Date 15-7-16 下午5:19
 */
@Data
public class Errors {

    private int code = HttpResponseCode.失败_前端展示.code;

    private Object[] args;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
