package com.itedu365.ssi.framework.util;

import com.itedu365.ssi.framework.checker.RegEXChecker;


public class UtilsTest {

    public static void main(String[] args) {
        System.out.println(RegEXChecker.validate("/msg/*","/msg/sss.do" ));
    }

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
}
