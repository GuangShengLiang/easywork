package com.github.easywork.exception;

public class AuthorityException extends BaseException {
    public AuthorityException() {
        super();
    }

    public AuthorityException(String message) {
        super(message);
    }

    public AuthorityException(int code, String message) {
        super(code, message);
    }

}
