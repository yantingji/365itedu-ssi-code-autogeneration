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

/**
 * 其他小工具类。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public class OtherUtil {

    /**
     * 最小密码长度
     */
    private static final Integer MIN_PASSWORD_LENGTH_8 = 8;

    /**
     * 加权值3
     */
    private static final Integer BONUS_3 = 3;

    /**
     * 加权值4
     */
    private static final Integer BONUS_4 = 4;

    /**
     * 加权值5
     */
    private static final Integer BONUS_5 = 5;

    /**
     * 加权值15
     */
    private static final Integer BONUS_15 = 15;

    /**
     * 加权值25
     */
    private static final Integer BONUS_25 = 25;

    /**
     * 加权值35
     */
    private static final Integer BONUS_35 = 35;

    /**
     * 分析密码强度。
     * @param password 密码
     * @return 强度数值
     */
    public static int analyzePassWord(String password) {
        int score = 0;
        int bonus = 0;
        int excess = 0;
        int upper = 0;
        int numbers = 0;
        int symbols = 0;

        excess = password.length() - MIN_PASSWORD_LENGTH_8;

        // 文字种类
        for (int i = 0; i < password.length(); i++) {
            if (password.substring(i, i + 1).matches("[A-Z]")) {
                upper++;
                continue;
            }
            if (password.substring(i, i + 1).matches("[0-9]")) {
                numbers++;
                continue;
            }
            if (password.substring(i, i + 1).matches("[#$%&@*+-_.~]")) {
                symbols++;
                continue;
            }
        }
        // 组合加权
        if (upper > 0 && numbers > 0 && symbols > 0) {
            bonus = BONUS_25;
        } else if ((upper > 0 && numbers > 0) || (upper > 0 && symbols > 0) || (numbers > 0 && symbols > 0)) {
            bonus = BONUS_15;
        }
        // 只有小写
        if (password.matches("^[a-z]+$")) {
            bonus = bonus - BONUS_15;
        }
        // 只有大写
        if (password.matches("^[A-Z]+$")) {
            bonus = bonus - BONUS_25;
        }
        // 只有数字
        if (password.matches("^[0-9]+$")) {
            bonus = bonus - BONUS_35;
        }
        score = (excess * BONUS_3) + (upper * BONUS_4) + (numbers * BONUS_5) + (symbols * BONUS_5) + bonus;
        return score;
    }

    /**
     * 得到系统换行符合。
     * @return 系统换行符合
     */
    public static String getLineSeparator() {

        final String lineSeparator = System.getProperty("line.separator");
        return lineSeparator;
    }

}
