package com.github.easywork.exception;

/**
 * Created by user on 2016/8/8.
 */
public class AuthorityException extends BaseException {
    public AuthorityException(){
        super();
    }

    public AuthorityException(String message){
        super(message);
    }

    public AuthorityException(int code, String message){
        super(code,message);
    }

}
