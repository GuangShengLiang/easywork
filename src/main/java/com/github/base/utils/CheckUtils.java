package com.github.base.utils;

import com.github.base.exception.BizException;

import java.util.Collection;

/**
 * @Author lgs
 * @Date 15-12-7 下午5:18
 */
public class CheckUtils {

    /**
     * if reference is null then throw BizException(msg)
     * @param reference
     * @param msg
     */
    public void notNull(Object reference, String msg){
        if (reference == null){
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
