package com.github.base.utils;

/**
 * @Author lgs
 * @Date 15-11-22 下午2:58
 */
public class ConditionUtils {

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

    /**
     * @deprecated
     * @param source
     * @param expects
     * @return
     */
    public static boolean in(Object source, Object... expects) {
        if (source == null) {
            return false;
        }
        for (Object expect : expects) {
            if (source instanceof String){
                if (expect instanceof Byte){
                    expect = String.valueOf(expect);
                }
            }
            if (source instanceof Byte){
                source = source.toString();
                if (expect instanceof Byte){
                    expect = expect.toString();
                }
            }
            if (source instanceof Long){
                if (expect instanceof Integer){
                    expect = ((Integer) expect).longValue();
                }
            }
            if (source instanceof Integer){
                source =  ((Integer) source).longValue();
                if (expect instanceof Integer){
                    expect = ((Integer) expect).longValue();
                }
            }
            if (source.equals(expect)) {
                return true;
            }
        }
        return false;
    }

}
