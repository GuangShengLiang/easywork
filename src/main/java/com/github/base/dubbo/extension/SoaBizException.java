package com.github.base.dubbo.extension;

import com.github.base.exception.BaseException;

/**
 * @Author lgs
 * @Date 15-7-17 下午2:58
 */
public class SoaBizException extends BaseException {

    public SoaBizException(){
        super();
    }

    public SoaBizException(String message){
        super(message);
    }

    public SoaBizException(String code, String message){
        super(code,message);
    }

}
