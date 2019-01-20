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

import javax.servlet.ServletException;

/**
 * 未登陆异常处理类。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public class UnauthenticatedException extends ServletException {

    /**
     * 版本序列号
     */
    private static final long serialVersionUID = 5461915996653164508L;
    // 不用任何处理，直接向上抛出异常，由服务器容器处理异常。
}
