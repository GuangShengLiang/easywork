package com.github.easywork.domain.error;

import lombok.Data;

@Data
public class ErrorMessage {

    private int code;

    private String message;

    public ErrorMessage() {

    }

    public ErrorMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
