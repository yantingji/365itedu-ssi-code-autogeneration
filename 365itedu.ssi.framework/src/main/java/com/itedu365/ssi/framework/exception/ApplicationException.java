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

/**
 * 应用程序异常处理类。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public class ApplicationException extends RuntimeException {

    /**
     * 版本序列号
     */
    private static final long serialVersionUID = 1435452808225157409L;

    /**
     * 错误事件方法
     */
    private String errorEventMethod;

    /**
     * 构造函数。
     * @param cause 例外的原因
     */
    public ApplicationException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数。
     * @param errorEventName 错误事件名称
     */
    public ApplicationException(String errorEventMethod) {
        this.errorEventMethod = errorEventMethod;
    }

    /**
     * 取得错误事件名称。
     * @return 错误事件名称
     */
    public String getErrorEventMethod() {
        return errorEventMethod;
    }

    /**
     * 设定错误事件方法。
     * @param errorEventName 错误事件名称
     */
    public void setErrorEventMethod(String errorEventMethod) {
        this.errorEventMethod = errorEventMethod;
    }

}
