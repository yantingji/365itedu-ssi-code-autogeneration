/*
 * Copyright (C) 2013～2023 上海颐凡软件科技有限公司
 * Yfann Software Technology (Shanghai) Co.,LTD  
 * All Rights Reserved.
 * 公司网址: www.yfann.com
 * 365IT教育网，成就您高品质的国际软件架构师之梦！
 * 平台网址:
 *         www.365itedu.com
 */

package com.itedu365.ssi.framework.filter;

import javax.servlet.ServletRequest;

/**
 * URL权限资源访问控制接口。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public interface AuthorizationController {

    /**
     * 对于请求的路径、根据Session内容进行权限验证。
     * @param pathInfo String
     * @param req ServletRequest
     * @return 权限检查成功的话 <code>true</code>。
     */
    boolean isAuthorized(String pathInfo, ServletRequest req);

    /**
     * 判断所访问的URL是否需要权限验证检查。
     * @param req ServletRequest <code>ServletRequest</code>
     * @return 如果需要验证返回<code>true</code>
     */
    boolean isCheckRequired(ServletRequest req);

}
