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

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.itedu365.ssi.framework.exception.ApplicationException;

/**
 * 控制过滤器抽象类。
 * @param <E> 指定控制类
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public abstract class AbstractControlFilter<E> implements Filter {

    /**
     * 日志
     */
    private static Log log = LogFactory.getLog(AbstractControlFilter.class);

    /**
     * 过滤器
     */
    protected FilterConfig config;

    /**
     * 服务器启动时初始化处理。
     * @param config FilterConfig。
     * @throws javax.servlet.ServletException 。
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig config) throws ServletException {
        this.setConfig(config);
    }

    /**
     * 设定配置文件。
     * @param config 配置文件信息
     */
    protected void setConfig(FilterConfig config) {
        if (log.isDebugEnabled()) {
            log.debug("setConfig() called.");
        }
        this.config = config;
    }

    /**
     * 从DI容器里取得实例。
     * @return E 取得的控制器实例
     */
    @SuppressWarnings("unchecked")
    protected E getController() {

        if (log.isDebugEnabled()) {
            log.debug("setController() called.");
        }

        // WebApplicationContext取得
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());

        String controllerId = config.getInitParameter("controller");
        if (controllerId == null || "".equals(controllerId)) {
            if (log.isDebugEnabled()) {
                log.debug("init parameter 'controller' isn't defined or " + "empty");
            }
            controllerId = getDefaultControllerBeanId();
        }

        if (log.isDebugEnabled()) {
            log.debug("controller bean id = \"" + controllerId + "\"");
        }

        // 从DI容器里取得实例
        E controller = null;
        try {
            controller = (E) wac.getBean(controllerId, getControllerClass());
        } catch (NoSuchBeanDefinitionException e) {
            log.error("not found " + controllerId + ". " + "controller bean not defined in Beans definition file.", e);
            throw new ApplicationException(e);
        } catch (BeanNotOfRequiredTypeException e) {
            log.error("controller not implemented " + getControllerClass().toString() + ".", e);
            throw new ApplicationException(e);
        } catch (BeansException e) {
            // 实例生成错误的情况
            log.error("bean generation failed.", e);
            throw new ApplicationException(e);
        }
        return controller;
    }

    /**
     * 返回访问控制类中必须装载的实例类。
     * @return 本过滤器中使用的控制器类
     */
    protected abstract Class<?> getControllerClass();

    /**
     * 控制器生成失败时，返回的错误编码。
     * @return 错误编码
     */
    protected abstract String getErrorCode();

    /**
     * 从DI容器里面取得默认ID。
     * @return 默认id属性值
     */
    public abstract String getDefaultControllerBeanId();

    /**
     * 过滤器内部处理。
     * @param req ServletRequest
     * @param res ServletResponse
     * @param chain 过滤器链
     * @throws IOException I/O错误
     * @throws ServletException 例外
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse,
     *      javax.servlet.FilterChain)
     */
    public abstract void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
                                                                                             ServletException;

    /**
     * 过滤器销毁处理时被调用。<br>
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
        // 里面什么也不进行处理。
    }
}
