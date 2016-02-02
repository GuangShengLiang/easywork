package com.github.base.json;

import lombok.Data;

/**
 * @Author lgs
 * @Date 15-7-14 下午5:58
 */
@Data
public class ErrorMessage {

    private String code;

    private String message;

    public ErrorMessage() {

    }

    public ErrorMessage(String code, String message){
        this.code = code;
        this.message = message;
    }
}
