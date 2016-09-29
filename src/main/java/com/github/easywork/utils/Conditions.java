package com.github.easywork.utils;

/**
 * @Author lgs
 * @Date 15-11-22 下午2:58
 */
public class Conditions {

    /**
     * 源值是否在期望的值中
     * example
     * in("a","a","b") return true;
     * in("a","b","c") return false;
     * in(null,...) return false;
     *
     * @param source  源值
     * @param expects 期望值
     * @return
     */
    public static boolean in(String source, String... expects) {
        if (source == null) {
            return false;
        }
        for (String expect : expects) {
            if (source.equals(expect)) {
                return true;
            }
        }
        return false;
    }

    public static boolean inIgnoreCase(String source, String... expects) {
        if (source == null) {
            return false;
        }
        for (String expect : expects) {
            if (source.equalsIgnoreCase(expect)) {
                return true;
            }
        }
        return false;
    }

    public static boolean in(Integer source, Integer... expects) {
        if (source == null) {
            return false;
        }
        for (Integer expect : expects) {
            if (source.equals(expect)) {
                return true;
            }
        }
        return false;
    }

    public static boolean in(Long source, Long... expects) {
        if (source == null) {
            return false;
        }
        for (Long expect : expects) {
            if (source.equals(expect)) {
                return true;
            }
        }
        return false;
    }

}
