package com.github.base.utils;

import jodd.datetime.JDateTime;

import java.util.Date;

/**
 * Created by lgs on 16-2-18.
 */
public class DateTimeUtils {

    public final static String FORMAT_YYYY_MM_DD = "YYYY-MM-DD";

    public final static String FORMAT_YYYY_MM_DD_hh_mm_ss = "YYYY-MM-DD hh:mm:ss";
    /**
     * 获取昨天
     * @return
     */
    public static Date getYesterdayDate(){
        JDateTime jdt = new JDateTime();
        jdt.addDay(-1);
        return jdt.convertToDate();
    }

    /**
     * 字符串转日期
     * "2003-11-24 23:18:38.173"
     * "2003-11-23");                // 2003-11-23 00:00:00.000
     * "01.01.1975", "DD.MM.YYYY"  // 1975-01-01
     * "2001-01-31", "YYYY-MM-***" // 2001-01-01, since day is not parsed
     * @param str
     * @return
     */
    public static Date parse(String str){
        JDateTime jdt = new JDateTime();
        jdt.parse(str);
        return jdt.convertToDate();
    }

    /**
     * 格式化日期 YYYY-MM-DD
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, String format){
        JDateTime jdt = new JDateTime(date);
        return jdt.toString(format);
    }
    /**
     * 默认格式化日期
     * @param date
     * @return
     */
    public static String formatDate(Date date){
        return formatDate(date,FORMAT_YYYY_MM_DD);
    }

}
