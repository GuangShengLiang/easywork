package com.github.easywork.exception;


import com.github.easywork.domain.error.Errors;

public class BaseException extends RuntimeException {

    protected Errors errors = new Errors();

    public BaseException(String message) {
        super(message);
    }

    public BaseException(int code, String message) {
        super(message);
        this.errors.setCode(code);
    }

    public BaseException() {
        super();
    }

    public Errors getErrors() {
        return errors;
    }

    public void injectError(int code) {
        this.errors.setCode(code);
    }

    public void injectError(int code, Object[] args) {
        this.errors.setCode(code);
        this.errors.setArgs(args);
    }
}
