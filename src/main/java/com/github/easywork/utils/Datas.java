package com.github.easywork.utils;

import com.github.easywork.exception.BizException;
import com.github.easywork.interfaces.Execute;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;

/**
 * Created by user on 2016/8/5.
 */
@Slf4j
public class Datas {

    public static <T> T single(Iterable<T> iterable) {

         return Optional.ofNullable(iterable).map(e->e.iterator()).filter(f->f.hasNext()).map(e->e.next()).orElse(null);
    }

    public static <T> T singleRequired(Iterable<T> iterable) {
        Iterator<T> iterator= iterable.iterator();
        if (!iterator.hasNext()) {
            throw new BizException("not found data");
        }
        return iterator.next();

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

    public static void when(boolean exp, Execute function) {
        function.execute();
    }

    public static <T> T getOrDefault(T t, T defaultValue) {
        return Optional.ofNullable(t).orElse(defaultValue);
    }

    public static <T, R> List<R> newLinkedList(Collection<T> collection, Function<T, R> function) {
        List<R> list = Lists.newLinkedList();
        collection.forEach(e -> {
            list.add(function.apply(e));
        });
        return list;
    }

    public static <T, R> Set<R> newHashSet(Collection<T> collection, Function<T, R> function) {
        if (collection == null){
            return Sets.newHashSet();
        }
        Set<R> set = Sets.newHashSetWithExpectedSize(collection.size());
        collection.forEach(e -> {
            set.add(function.apply(e));
        });
        return set;
    }

    public static <V, K> Map<K, V> newHashMap(Collection<V> collection, Function<V, K> function) {
        if (collection == null){
            return Maps.newHashMap();
        }
        Map<K, V> map = Maps.newHashMapWithExpectedSize(collection.size());
        collection.forEach(e -> {
            map.put(function.apply(e), e);
        });
        return map;
    }

    public static <V, K, T> Map<K, V> newHashMap(Collection<T> collection, Function<T, K> keyFunction, Function<T, V> valueFunction) {
        if (collection == null){
            return Maps.newHashMap();
        }
        Map<K, V> map = Maps.newHashMapWithExpectedSize(collection.size());
        collection.forEach(e -> {
            map.put(keyFunction.apply(e), valueFunction.apply(e));
        });
        return map;
    }

    public static <T> void exportTable(String fileName, HttpServletResponse response, List<String> header, List<T> data, Function<T, List> function) throws IOException {
//      rest  header
        response.setHeader("content-disposition", "attachment;filename=" + fileName);
        response.setContentType("application/octet-stream");
//        table header
        String head = Joiner.on(",").useForNull("").join(header) + "\r";
        response.getOutputStream().write(head.getBytes());
//        row data
        data.forEach(t -> {
            String row = Joiner.on(",").useForNull("").join(function.apply(t)) + "\r";
            try {
                response.getOutputStream().write(row.getBytes());
            } catch (IOException e) {
                log.error("write response error", e);
            }

        });
    }
}
