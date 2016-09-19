package com.github.easywork.json;

import lombok.Data;

/**
 * @Author lgs
 * @Date 15-7-14 下午5:58
 */
@Data
public class ErrorMessage {

    private int code;

    private String message;

    public ErrorMessage() {

    }

    public ErrorMessage(int code, String message){
        this.code = code;
        this.message = message;
    }
}
