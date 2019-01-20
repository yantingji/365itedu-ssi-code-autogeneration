/*
 * Copyright (C) 2013～2023 上海颐凡软件科技有限公司
 * Yfann Software Technology (Shanghai) Co.,LTD  
 * All Rights Reserved.
 * 公司网址: www.yfann.com
 * 365IT教育网，成就您高品质的国际软件架构师之梦！
 * 平台网址:
 *         www.365itedu.com
 */

package com.itedu365.ssi.framework.constants;

/**
 * 框架正则表达式常量定义类。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public class FrameworkRegEXConst {

    /**
     * 正则表达式:整数
     */
    public static final String REG_EX_NUMBER = "^-?[1-9]d*$";

    /**
     * 正则表达式:数字字符串
     */
    public static final String REG_EX_NUMBER_STRING = "^[0-9]*d*$";

    /**
     * 正则表达式:双精度浮点数
     */
    public static final String REG_EX_DOUBLE = "^-?([1-9]d*.d*|0.d*[1-9]d*|0?.0+|0)$";

    /**
     * 正则表达式:26个英文字母
     */
    public static final String REG_EX_26_ENGLISH = "^[A-Za-z]+$";

    /**
     * 正则表达式:26个英文大写字母
     */
    public static final String REG_EX_26_UPPER_ENGLISH = "^[A-Z]+$";

    /**
     * 正则表达式:26个英文小写字母
     */
    public static final String REG_EX_26_LOWER_ENGLISH = "^[a-z]+$";

    /**
     * 正则表达式:26个英文字母和数字
     */
    public static final String REG_EX_26_NENGLISH_UMBER = "^[A-Za-z0-9]+$";

    /**
     * 正则表达式:26个英文字母、数字或者下划线
     */
    public static final String REG_EX_26_ENGLISH_NUMBER_UNDERLINE = "^[a-zA-Z0-9_@]+$";

    /**
     * 正则表达式:汉字
     */
    public static final String REG_EX_CHINESE = "^[u4e00-u9fa5],{0,}$";

    /**
     * 正则表达式:Email地址
     */
    public static final String REG_EX_EMAIL = "^[a-zA-Z0-9_\\.]+@[a-zA-Z0-9-]+[\\.a-zA-Z]+$";

    /**
     * 正则表达式:InternetURL
     */
    public static final String REG_EX_URL = "^http://([w-]+.)+[w-]+(/[w-./?%&=]*)?$";

    /**
     * 正则表达式:电话号码
     */
    public static final String REG_EX_PHONE = "^((d{3,4})|d{3,4}-)?d{7,8}$";

    /**
     * 正则表达式:身份证号（15位或18位数字）
     */
    public static final String REG_EX_IDENTFICATION = "^d{15}|d{}18$";

    /**
     * 正则表达式:一年的12个月，正确格式为：“01”-“09”和“1”“12”
     */
    public static final String REG_EX_12_MONTH = "^(0?[1-9]|1[0-2])$";

    /**
     * 正则表达式:一个月的31天，正确格式为：“01”“09”和“1”“31”
     */
    public static final String REG_EX_31_DAY = "^((0?[1-9])|((1|2)[0-9])|30|31)$";

    /**
     * 正则表达式:HTML标记
     */
    public static final String REG_EX_HTML = "/< (.*)>.*|< (.*) />/";

}
