package com.github.base.exception;

/**
 * Created by user on 2016/8/8.
 */
public class AuthorityExeption extends BaseException {
    public AuthorityExeption(){
        super();
    }

    public AuthorityExeption(String message){
        super(message);
    }

    public AuthorityExeption(String code, String message){
        super(code,message);
    }

}
