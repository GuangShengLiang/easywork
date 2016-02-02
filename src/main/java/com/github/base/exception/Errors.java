package com.github.base.exception;

import lombok.Data;

/**
 * @Author lgs
 * @Date 15-7-16 下午5:19
 */
@Data
public class Errors {

    private String errorCode;

    private Object[] args;

    private String message;
}
