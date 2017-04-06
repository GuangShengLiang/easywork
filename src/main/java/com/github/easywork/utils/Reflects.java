package com.github.easywork.utils;

import java.lang.reflect.Field;

public class Reflects {

    public static <T> T getFieldValue(Object o, String field, Class<T> t) throws Exception {
        Field f = o.getClass().getDeclaredField(field);
        f.setAccessible(true);
        return (T) f.get(o);
    }
}
