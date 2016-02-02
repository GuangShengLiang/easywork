package com.github.base.utils;


/**
 * @Author lgs
 * @Date 15-12-3 上午11:12
 */
public class StringExt {

    public static String stringBuilder(String... strs){
        StringBuilder sb = new StringBuilder();
        for (String str : strs){
            sb.append(str);
        }
        return sb.toString();
    }

}
