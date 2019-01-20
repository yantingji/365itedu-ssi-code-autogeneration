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


/**
 * 必须输入验证类。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public final class RequiredChecker {

    /**
     * 构造函数。
     */
    private RequiredChecker() {

    }

    static {
        new RequiredChecker();
    }

    /**
     * 必须项目验证处理。
     * @param value 对象
     * @return 空的时候返回false，非空的时候返回true
     */
    public static boolean validate(Object value) {

        if (value == null) {
            return false;
        } else {
            String str = value.toString().trim();
            if (str.length() == 0) {
                return false;
            }
        }
        return true;
    }
}
