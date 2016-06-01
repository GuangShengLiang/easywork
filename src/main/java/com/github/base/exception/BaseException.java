package com.github.base.exception;


/**
 * @Author lgs
 * @Date 15-5-19 下午5:38
 */
public class BaseException extends RuntimeException {

    protected Errors errors = new Errors();

    public BaseException(String message){
        super(message);
    }
    public BaseException(String code, String message){
        super(message);
        this.errors.setErrorCode(code);
    }
    public BaseException(){
        super();
    }

    public Errors getErrors() {
        return errors;
    }

    public void injectError(String errorCode){
        this.errors.setErrorCode(errorCode);
    }

    public void injectError(String errorCode, Object[] args){
        this.errors.setErrorCode(errorCode);
        this.errors.setArgs(args);
    }
}
