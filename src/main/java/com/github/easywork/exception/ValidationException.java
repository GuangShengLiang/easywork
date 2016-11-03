package com.github.easywork.exception;

/**
 * Created by user on 2016/11/2.
 */
public class ValidationException extends BaseException {

    public ValidationException(){
        super();
    }

    public ValidationException(String message){
        super(message);
    }

    public ValidationException(int code, String message){
        super(code,message);
    }
}
