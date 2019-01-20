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

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.itedu365.ssi.framework.exception.UnauthorizedException;
import com.itedu365.ssi.framework.util.RequestUtil;

/**
 * URL权限资源访问控制过滤器类。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public class AuthorizationControlFilter extends AbstractControlFilter<AuthorizationController> {

    /**
     * 日志
     */
    private static Log log = LogFactory.getLog(AuthorizationControlFilter.class);

    /**
     * 默认id
     */
    public static final String DEFAULT_AUTHORIZATION_BEAN_ID = "authorizationController";

    /**
     * 错误编码
     */
    private static final String AUTHORIZATION_CONTROLLER_ERROR = "errors.authorization.controller";

    /**
     * URL权限资源访问处理控制类
     */
    private static final Class<AuthorizationController> AUTHORIZATION_CONTROLLER_CLASS = AuthorizationController.class;

    /**
     * AuthorizationController实例
     */
    protected static AuthorizationController controller;

    /**
     * 取得getAuthorizationController。
     * @return 返回getAuthorizationController实例
     */
    public static AuthorizationController getAuthorizationController() {
        return controller;
    }

    /**
     * 服务器启动时初始化处理。
     * @param config FilterConfig。
     * @throws javax.servlet.ServletException 。
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        super.init(config);
        if (controller == null) {
            controller = getController();
        }
    }

    /**
     * 进行URL权限资源访问认证处理。
     * @param req ServletRequest
     * @param res ServletResponse
     * @param chain 过滤器链
     * @throws IOException I/O错误
     * @throws ServletException 例外
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse,
     *      javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
                                                                                    ServletException {

        if (controller.isCheckRequired(req)) {

            if (!controller.isAuthorized(RequestUtil.getPathInfo(req), req)) {
                if (log.isDebugEnabled()) {
                    log.debug("isAuthorized() failed.");
                }
                throw new UnauthorizedException();
            }
        }

        chain.doFilter(req, res);
    }

    /**
     * 返回访问控制类中必须装载的实例类。
     * @return 本过滤器中使用的控制器类
     */
    @Override
    protected Class<AuthorizationController> getControllerClass() {
        return AUTHORIZATION_CONTROLLER_CLASS;
    }

    /**
     * 控制器生成失败时返回的错误编码。
     * @return 错误编码
     */
    @Override
    protected String getErrorCode() {
        return AUTHORIZATION_CONTROLLER_ERROR;
    }

    /**
     * 返回从DI容器里生成的控制器id。
     * @return 默认属性值
     */
    @Override
    public String getDefaultControllerBeanId() {
        return DEFAULT_AUTHORIZATION_BEAN_ID;
    }

}
