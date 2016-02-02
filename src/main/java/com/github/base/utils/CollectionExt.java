package com.github.base.utils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Author lgs
 * @Date 15-12-2 下午7:23
 */
public class CollectionExt {

    /**
     * 数组转换成linkedList
     * @param arrs
     * @param <T>
     * @return
     */
    public static <T> List<T> asList(T... arrs) {
        List list = new LinkedList();
        for (T t : arrs){
            list.add(t);
        }
        return list;
    }

    /**
     * 数组转换成Set
     * @param arrs
     * @param <T>
     * @return
     */
    public static <T> Set<T> asSet(T... arrs) {
        Set set = new HashSet<T>();
        for (T t : arrs){
            set.add(t);
        }
        return set;
    }
}
