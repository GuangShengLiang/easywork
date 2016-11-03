package com.github.easywork.utils;

import com.github.easywork.exception.BizException;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by user on 2016/8/5.
 */
public class Datas {

    public static <T> T single(Collection<T> results) {
        int size = results != null ? results.size() : 0;
        if (size == 0) {
            return null;
        }
        return results.iterator().next();
    }

    public static <T> T singleRequired(Collection<T> results) {
        int size = results != null ? results.size() : 0;
        if (size == 0) {
            throw new BizException("not found data");
        }
        return results.iterator().next();

    }

    public static <T> T singleOnly(Collection<T> results) {
        int size = results != null ? results.size() : 0;
        if (size == 0) {
            return null;
        } else if (results.size() > 1) {
            throw new BizException("too much row data");
        } else {
            return results.iterator().next();
        }
    }

    public static <T> T getOrDefault(T t, T defaultValue) {
        return Optional.ofNullable(t).orElse(defaultValue);
    }

    public static <T, R> List<R> convert(Collection<T> collection, Function<T, R> function) {
        List<R> list = Lists.newLinkedList();
        collection.forEach(e -> {
            list.add(function.apply(e));
        });
        return list;
    }

}
