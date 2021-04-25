package com.github.easywork.utils;

import com.github.easywork.exception.BizException;
import com.github.easywork.rest.IErrorCode;
import com.github.easywork.rest.RestCodeEnum;

import java.util.Collection;

/**
 * @Author lgs
 * @Date 15-12-7 下午5:18
 */
public class Asserts {

    /**
     * if reference is null then throw BizException(msg)
     *
     * @param ref
     * @param template
     */
    public static void notNull(final Object ref, final int code, final String template, Object... args) {
        if (ref == null) {
            throw new BizException(code, String.format(template, args));
        }
    }

    public static void notNull(final Object ref, IErrorCode err) {
        if (ref == null) {
            throw new BizException(err.getCode(), err.getMessage());
        }
    }

    public static void notNullMsg(final Object ref, final String field) {
        notNull(ref, RestCodeEnum.业务异常.code, "%s can't be null", field);
    }

    public static void notNullMsg(final Object ref, final int code, final String field) {
        notNull(ref, code, "%s can't be null", field);
    }

    public static void notNull(final Object ref, final String template, Object... args) {
        notNull(ref, RestCodeEnum.业务异常.code, template, args);
    }

    /**
     * if collection is empty then throw BizException(msg)
     *
     * @param collection
     */
    public static void notEmpty(final Collection collection, final String template, Object... args) {
        if (collection == null || collection.isEmpty()) {
            throw new BizException(String.format(template, args));
        }
    }

    public static void notEmpty(final Collection collection, final int code, final String template, Object... args) {
        if (collection == null || collection.isEmpty()) {
            throw new BizException(code, String.format(template, args));
        }
    }

    public static void whenThrow(final boolean expression,IErrorCode err) {
        if (expression) {
            throw new BizException(err.getCode(),err.getMessage());
        }
    }

    public static void whenThrow(final boolean expression, final String template, Object... args) {
        if (expression) {
            throw new BizException(String.format(template, args));
        }
    }

    public static void whenThrow(final boolean expression, final int code, final String template, Object... args) {
        if (expression) {
            throw new BizException(code, String.format(template, args));
        }
    }

}
