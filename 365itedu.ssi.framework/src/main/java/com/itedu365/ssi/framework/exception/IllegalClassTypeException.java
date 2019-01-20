/*
 * Copyright (C) 2013～2023 上海颐凡软件科技有限公司
 * Yfann Software Technology (Shanghai) Co.,LTD  
 * All Rights Reserved.
 * 公司网址: www.yfann.com
 * 365IT教育网，成就您高品质的国际软件架构师之梦！
 * 平台网址:
 *         www.365itedu.com
 */

package com.itedu365.ssi.framework.exception;

import org.springframework.dao.DataAccessException;

/**
 * QueryDAO数组变换出现例外时，抛出的异常类。<br>
 * 参数，返回值类型，以及Map数组变换时，DAO类中抛出的异常。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public class IllegalClassTypeException extends DataAccessException {

    /**
     * 版本序列号
     */
    private static final long serialVersionUID = -4110575577689733921L;

    /**
     * 错误消息
     */
    public static final String ERROR_ILLEGAL_CLASS_TYPE = "The illegal Class Type of the argument.";

    /**
     * 构造函数。
     */
    public IllegalClassTypeException() {
        super(ERROR_ILLEGAL_CLASS_TYPE);
    }

    /**
     * 构造函数。
     * @param message 错误消息
     */
    public IllegalClassTypeException(String message) {
        super(message);
    }

    /**
     * 构造函数。
     * @param cause 例外的原因
     */
    public IllegalClassTypeException(Throwable cause) {
        super(ERROR_ILLEGAL_CLASS_TYPE, cause);
    }

    /**
     * 构造函数。
     * @param message 错误消息
     * @param cause 例外的原因
     */
    public IllegalClassTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
