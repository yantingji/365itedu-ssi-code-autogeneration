/*
 * Copyright (C) 2013～2023 上海颐凡软件科技有限公司
 * Yfann Software Technology (Shanghai) Co.,LTD  
 * All Rights Reserved.
 * 公司网址: www.yfann.com
 * 365IT教育网，成就您高品质的国际软件架构师之梦！
 * 平台网址:
 *         www.365itedu.com
 */

package com.itedu365.ssi.framework.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.itedu365.ssi.framework.checker.RegEXChecker;
import com.itedu365.ssi.framework.constants.FrameworkRegEXConst;

/**
 * 日期相关工具类。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public class DateUtil {

    /**
     * 日期格式长度4
     */
    private static final Integer DAY_LENGTH_4 = 4;

    /**
     * 日期格式长度6
     */
    private static final Integer DAY_LENGTH_6 = 6;

    /**
     * 日期格式长度8
     */
    private static final Integer DAY_LENGTH_8 = 8;

    /**
     * 取得系统日期。
     * <p>
     * Web服务器与AP服务器分开的情况，根据机器的不同，取得的系统日期也会不同。<br>
     * 为了避免这种情况，系统日期的取得一定要用这个方法。必要的时候，可以指定特定的机器的日期。
     * </p>
     * @return 系统日期
     */
    public static Date getSystemTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * 取得按照指定格式日期。
     * <p>
     * 取得当前系统日期后，根据格式进行编辑,转换成自己相要的格式,比如yyyyMMddhhmmss，或者yyyy/MM/dd hh:mm:ss
     * </p>
     * @param format 数据格式
     * @return 按照指定格式日期
     */
    public static String getFormatedCurrentDate(String format) {
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        String sysDatetime = fmt.format(getSystemTime());
        return sysDatetime;
    }

    /**
     * 取得没有0数字的特地格式日期。
     * <p>
     * 取得当前系统日期后，根据格式进行编辑,转换成yyyy-MM-dd hh:mm:ss。 其中各部分时间的数字小于10的时候，去掉前面的0。如2014-1-2 2:1:1
     * </p>
     * @param format 数据格式
     * @return 按照指定格式日期
     */
    public static String getNo0CurrentDate() {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sysDatetime = fmt.format(getSystemTime());
        String month = sysDatetime.substring(5, 7);
        String dd = sysDatetime.substring(8, 10);
        String hh = sysDatetime.substring(11, 13);
        String mm = sysDatetime.substring(14, 16);
        String ss = sysDatetime.substring(17, 19);
        if (Integer.valueOf(sysDatetime.substring(5, 7)) < 10) {
            month = (Integer.valueOf(sysDatetime.substring(5, 7))).toString();
        }
        if (Integer.valueOf(sysDatetime.substring(8, 10)) < 10) {
            dd = (Integer.valueOf(sysDatetime.substring(8, 10))).toString();
        }
        if (Integer.valueOf(sysDatetime.substring(11, 13)) < 10) {
            hh = (Integer.valueOf(sysDatetime.substring(11, 13))).toString();
        }
        if (Integer.valueOf(sysDatetime.substring(14, 16)) < 10) {
            mm = (Integer.valueOf(sysDatetime.substring(14, 16))).toString();
        }
        if (Integer.valueOf(sysDatetime.substring(17, 19)) < 10) {
            ss = (Integer.valueOf(sysDatetime.substring(17, 19))).toString();
        }
        sysDatetime = sysDatetime.substring(0, 5) + month + "-" + dd + " " + hh + ":" + mm + ":" + ss;
        return sysDatetime;
    }
    
    /**
     * 取得固定格式（yyyy-MM-dd hh:mm:ss）日期。
     * <p>
     * 把YYYYmmddHHmmss格式日期,转换成yyyy-MM-dd hh:mm:ss。 
     * </p>
     * @param format 数据格式
     * @return 按照指定格式日期
     */
    public static String getFormattedDate(String date) {
        String fommatedDate="";
        if(StringUtil.isNullOrEmpt(date) || date.length()<14){
            return null;
        }
        String month = date.substring(4, 6);
        String dd = date.substring(6, 8);
        String hh = date.substring(8, 10);
        String mm = date.substring(10, 12);
        String ss = date.substring(12, 14);
        fommatedDate = date.substring(0, 4)+ "-" + month + "-" + dd + " " + hh + ":" + mm + ":" + ss;
        return fommatedDate;
    }

    /**
     * 把带有0数字的日期转换成不带有有0数字的特地格式日期。
     * <p>
     * 把yyyyMMddHHmmss格式日期,转换成yyyy-MM-dd HH:mm:ss。<br>
     * 其中各部分时间的数字小于10的时候，去掉前面的0。如2014-1-2 2:1:1
     * </p>
     * @param format 数据格式
     * @return 按照指定格式日期
     */
    public static String changeToNo0TimeFomart(String has0Data) {
        if (StringUtil.isNullOrEmpt(has0Data)) {
            return "";
        }
        String resultData = "";
        String month = has0Data.substring(4, 6);
        String dd = has0Data.substring(6, 8);
        String hh = has0Data.substring(8, 10);
        String mm = has0Data.substring(10, 12);
        String ss = has0Data.substring(12, 14);
        if (Integer.valueOf(month) < 10) {
            month = (Integer.valueOf(month)).toString();
        }
        if (Integer.valueOf(dd) < 10) {
            dd = (Integer.valueOf(dd)).toString();
        }
        if (Integer.valueOf(hh) < 10) {
            hh = (Integer.valueOf(hh)).toString();
        }
        if (Integer.valueOf(mm) < 10) {
            mm = (Integer.valueOf(mm)).toString();
        }
        if (Integer.valueOf(ss) < 10) {
            ss = (Integer.valueOf(ss)).toString();
        }
        resultData = has0Data.substring(0, 4) + "-" + month + "-" + dd + " " + hh + ":" + mm + ":" + ss;
        return resultData;
    }

    /**
     * 取得按照指定格式加减日期计算后日期。
     * <p>
     * 根据传入基准日期，按照需求对日进行加减计算。<br>
     * 对计算结果格式进行编辑,转换成自己相要的格式,比如yyyyMMddhhmmss，或者yyyy/MM/dd hh:mm:ss
     * </p>
     * @param baseDay 基准日期
     * @param extendDay 加减日期天数
     * @param format 数据格式
     * @return 按照指定格式日期
     */
    public static String getFormatedCalculateDay(String baseDay, Integer extendDay, String format) {
        Calendar calendar = Calendar.getInstance();
        if (StringUtil.isNotEmptStr(baseDay) && baseDay.length() == DAY_LENGTH_8) {
            calendar.set(Calendar.YEAR, Integer.valueOf(baseDay.substring(0, DAY_LENGTH_4)));
            calendar.set(Calendar.MONTH, Integer.valueOf(baseDay.substring(DAY_LENGTH_4, DAY_LENGTH_6)) - 1);
            calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(baseDay.substring(DAY_LENGTH_6, DAY_LENGTH_8)));
        }
        int day = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.set(Calendar.DAY_OF_YEAR, day + extendDay);
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        String strDay = fmt.format(calendar.getTime());
        return strDay;
    }

    /**
     * 取得当前距1970年的毫秒。
     * @return 毫秒
     */
    public static Long getMillisecond() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeInMillis();
    }

    /**
     * 判断日期格式是否是YYYY-MM-DD。
     * @return true
     */
    public static boolean isYYYY_MM_DD_Date(String str) {

        int first = str.indexOf('-');
        int second = str.lastIndexOf('-');

        if (first == second) {
            // System.out.println("您输入的日期缺少\"-\"符号");
            return false;
        } else {
            String year = str.substring(0, first);
            String month = str.substring(first + 1, second);
            String day = str.substring(second + 1, str.length());
            int maxDays = 31;
            if (RegEXChecker.validate(FrameworkRegEXConst.REG_EX_NUMBER_STRING, year) == false
                    || RegEXChecker.validate(FrameworkRegEXConst.REG_EX_NUMBER_STRING, month) == false
                    || RegEXChecker.validate(FrameworkRegEXConst.REG_EX_NUMBER_STRING, day) == false) {
                // System.out.println("您输入的日期包含不可用字符");
                return false;
            } else if (year.length() < 4) {
                // System.out.println("您输入的年份少于四位");
                return false;
            }
            int y = Integer.parseInt(year);
            int m = Integer.parseInt(month);
            int d = Integer.parseInt(day);
            if (m > 12 || m < 1) {
                // System.out.println("您输入的月份不在规定范围内");
                return false;
            } else if (m == 4 || m == 6 || m == 9 || m == 11) {
                maxDays = 30;
            } else if (m == 2) {
                if (y % 4 > 0)
                    maxDays = 28;
                else if (y % 100 == 0 && y % 400 > 0)
                    maxDays = 28;
                else
                    maxDays = 29;
            }
            if (d < 1 || d > maxDays) {
                // System.out.println("您输入的日期不在规定范围内");
                return false;
            }
        }
        return true;
    }
}
