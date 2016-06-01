package com.github.base.utils;

import java.text.NumberFormat;

/**
 * Created by lgs on 16-4-20.
 */
public class MathUtils {

    public static String getPercent(Integer a, Integer b){
        if (a == null || b == null){
            return "0.00%";
        }
        NumberFormat format = NumberFormat.getPercentInstance();// 获取格式化类实例
        format.setMinimumFractionDigits(2);// 设置小数位
//        float c = a;
//        float d = b;
        return format.format((float)a / (float)b);// 打印计算结果
    }
    public static String getPercent(Double a, Double b){
        if (a == null || b == null){
            return "0.00%";
        }
        NumberFormat format = NumberFormat.getPercentInstance();// 获取格式化类实例
        format.setMinimumFractionDigits(2);// 设置小数位

        return format.format(a / b);// 打印计算结果
    }

    public static String getPercent(Long a, Long b){
        if (a == null || b == null){
            return "0.00%";
        }
        NumberFormat format = NumberFormat.getPercentInstance();// 获取格式化类实例
        format.setMinimumFractionDigits(2);// 设置小数位

        return format.format(a / b);// 打印计算结果
    }
}
