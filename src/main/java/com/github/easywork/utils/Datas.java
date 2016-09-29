package com.github.easywork.utils;

import com.github.easywork.exception.BizException;

import java.util.Collection;

/**
 * Created by user on 2016/8/5.
 */
public class Datas {

    public static <T> T singleResult(Collection<T> results){
        int size = results != null?results.size():0;
        if(size == 0) {
            return null;
        }
        return results.iterator().next();
    }

    public static <T> T singleResultRequired(Collection<T> results){
        int size = results != null?results.size():0;
        if(size == 0) {
            throw new BizException("not found data");
        }
        return results.iterator().next();

    }

    public static <T> T singleResultOnly(Collection<T> results) {
        int size = results != null?results.size():0;
        if(size == 0) {
            return null;
        } else if(results.size() > 1) {
            throw new BizException("too much row data");
        } else {
            return results.iterator().next();
        }
    }
}
