package com.github.base.exception;

/**
 * @Author lgs
 * @Date 15-7-17 下午2:58
 */
public class BizException extends BaseException {

    public BizException(){
        super();
    }

    public BizException(String message){
        super(message);
    }

    public BizException(String code, String message){
        super(code,message);
    }

}
