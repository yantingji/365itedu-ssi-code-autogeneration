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
 * 输入验证异常处理类。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public class CheckErrorException extends RuntimeException {

    /**
     * 版本序列号
     */
    private static final long serialVersionUID = -8438877720937827078L;

    /**
     * 错误事件方法
     */
    private String errorEventMethod;

    /**
     * 构造函数。
     * @param errorEventMethod 错误事件方法
     */
    public CheckErrorException(String errorEventMethod) {
        this.errorEventMethod = errorEventMethod;
    }

    /**
     * 取得错误事件方法。
     * @return 错误事件方法
     */
    public String getErrorEventMethod() {
        return errorEventMethod;
    }

    /**
     * 设定错误事件方法。
     * @param errorEventMethod 错误事件方法
     */
    public void setErrorEventMethod(String errorEventMethod) {
        this.errorEventMethod = errorEventMethod;
    }

}
