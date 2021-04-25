package com.github.easywork.utils;

import jodd.datetime.JDateTime;

import java.util.Date;

/**
 * Created by lgs on 16-2-18.
 */
public class Dates {

    public final static String YYYY_MM_DD = "YYYY-MM-DD";

    public final static String YYYY_MM_DD_hh_mm_ss = "YYYY-MM-DD hh:mm:ss";

    private final static String[] week = {"周一", "周二", "周三", "周四", "周五", "周六", "周日"};

    /**
     * 字符串转日期
     * "2003-11-24 23:18:38.173"
     * "2003-11-23");                // 2003-11-23 00:00:00.000
     * "01.01.1975", "DD.MM.YYYY"  // 1975-01-01
     * "2001-01-31", "YYYY-MM-***" // 2001-01-01, since day is not parsed
     *
     * @param str
     * @return Date
     */
    public static Date parse(String str) {
        JDateTime jdt = new JDateTime();
        jdt.parse(str);
        return jdt.convertToDate();
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param format 格式
     * @return
     */
    public static String format(Date date, String format) {
        JDateTime jdt = new JDateTime(date);
        return jdt.toString(format);
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return YYYY-MM-DD
     */
    public static String format(Date date) {
        return format(date, YYYY_MM_DD);
    }

    /**
     * 获取周的第几天
     *
     * @param date
     * @param dayOfWeek 周的第几天
     * @return YYYY-MM-DD
     */
    public static String getDayOfWeek(Date date, int dayOfWeek) {
        JDateTime jdt = new JDateTime(date);
        return jdt.addDay(dayOfWeek - jdt.getDayOfWeek()).toString(YYYY_MM_DD);
    }

    /**
     * 获取月的第几天
     *
     * @param date       日期
     * @param dayOfMonth 月的第几天
     * @return YYYY-MM-DD
     */
    public static String getDayOfMonth(Date date, int dayOfMonth) {
        JDateTime jdt = new JDateTime(date);
        return jdt.addDay(dayOfMonth - jdt.getDayOfMonth()).toString(YYYY_MM_DD);
    }

    /**
     * 获取月的第几天
     *
     * @param date       日期
     * @return YYYY-MM-DD
     */
    public static String dayOfWeek(Date date) {
        JDateTime jdt = new JDateTime(date);
        return week[jdt.getDayOfWeek()-1];
    }

    /**
     * 获取年
     *
     * @param date
     * @param years 加减年
     * @return YYYY-MM-DD
     */
    public static String getYear(Date date, int years) {
        JDateTime jdt = new JDateTime(date);
        return jdt.addYear(years).toString(YYYY_MM_DD);
    }

    /**
     * 获取年
     *
     * @param date
     * @param years 加减年
     * @return YYYY-MM-DD
     */
    public static int getYear(Date date, int years, int months) {
        JDateTime jdt = new JDateTime(date);
        return jdt.addYear(years).addMonth(months).getYear();
    }

    /**
     * 获取日期
     *
     * @param date
     * @param days 加减天数
     * @return YYYY-MM-DD
     */
    public static String addDay(Date date, int days) {
        JDateTime jdt = new JDateTime(date);
        jdt.addDay(days);
        return jdt.toString(YYYY_MM_DD);
    }

    /**
     * 获取日期
     *
     * @param days 加减天数
     * @return YYYY-MM-DD
     */
    public static String addDay(int days) {
        JDateTime jdt = new JDateTime();
        jdt.addDay(days);
        return jdt.toString(YYYY_MM_DD);
    }

    /**
     * 获取日期
     *
     * @param date
     * @return YYYY-MM-DD
     */
    public static String addDay(Date date, int years, int months, int days) {
        JDateTime jdt = new JDateTime(date);
        jdt.add(years, months, days);
        return jdt.toString(YYYY_MM_DD);
    }

    /**
     * 获取日期
     *
     * @param date
     * @return date
     */
    public static Date add(Date date, int years, int months, int days) {
        JDateTime jdt = new JDateTime(date);
        jdt.add(years, months, days);
        return jdt.convertToDate();
    }

    /**
     * 获取日期
     *
     * @param date
     * @param days 加减天数
     * @return
     */
    public static Date add(Date date, int days) {
        return new JDateTime(date).addDay(days).convertToDate();

    }

}
