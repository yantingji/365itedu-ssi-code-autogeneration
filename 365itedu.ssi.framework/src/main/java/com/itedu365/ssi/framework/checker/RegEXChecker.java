/*
 * Copyright (C) 2013～2023 上海颐凡软件科技有限公司
 * Yfann Software Technology (Shanghai) Co.,LTD
 * All Rights Reserved.
 * 公司网址: www.yfann.com
 * 365IT教育网，成就您高品质的国际软件架构师之梦！
 * 平台网址:
 *         www.365itedu.com
 */

package com.itedu365.ssi.framework.checker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.itedu365.ssi.framework.util.StringUtil;

/**
 * 正则表达式验证类。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public final class RegEXChecker {

    /**
     * 构造函数。
     */
    private RegEXChecker() {

    }

    static {
        new RegEXChecker();
    }

    /**
     * 正则表达式验证处理。
     * @param regEx 正则表达式格式
     * @param value 被验证字符串
     * @return 验证成功返回true，验证失败返回false。
     */
    public static boolean validate(String regEx, Object value) {
        if (StringUtil.isNotEmptStr(regEx) && value != null) {
            Pattern pat = Pattern.compile(regEx);
            Matcher mat = pat.matcher(value.toString());
            if (!mat.find()) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

}
