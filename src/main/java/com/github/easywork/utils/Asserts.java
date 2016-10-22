package com.github.easywork.utils;

import com.github.easywork.exception.BizException;

import java.util.Collection;

/**
 * @Author lgs
 * @Date 15-12-7 下午5:18
 */
public class Asserts {

    /**
     * if reference is null then throw BizException(msg)
     * @param reference
     * @param msg
     */
    public void notNull(Object ref, String template, Object ... args){
        if (ref == null){
            throw new BizException(String.format(template,args));
        }
    }
    public void notNull(Object ref, String field){
        notNull(ref,"%s can't be null",field);
    }
    public void notNullMsg(Object ref, String msg){
        if (ref == null){
            throw new BizException(msg);
        }
    }
    /**
     * if collection is empty then throw BizException(msg)
     * @param collection
     * @param msg
     */
    public void notEmpty(Collection collection, String msg){
        if (collection == null || collection.isEmpty()){
            throw new BizException(msg);
        }
    }
}
