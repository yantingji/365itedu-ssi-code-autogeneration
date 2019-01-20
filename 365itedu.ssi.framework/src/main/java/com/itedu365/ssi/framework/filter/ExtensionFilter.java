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
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.itedu365.ssi.framework.exception.ProhibitedException;
import com.itedu365.ssi.framework.util.PropertyUtil;
import com.itedu365.ssi.framework.util.RequestUtil;
import com.itedu365.ssi.framework.util.StringUtil;

/**
 * 禁止访问扩展名过滤器类。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public class ExtensionFilter implements Filter {

    /**
     * 日志
     */
    private static Log log = LogFactory.getLog(ExtensionFilter.class);

    /**
     * 可以访问的扩展名前缀
     */
    public static final String RESTRICTION_ESCAPE_PREFIX = "restrictionEscape.";

    /**
     * 扩展名访问禁止定义列表键路径
     */
    private static final String PROHIBITED_EXTENSION_PREFIX = "access.control.prohibited.extension.";

    /**
     * 从Web浏览器里，不能够直接访问的扩展名后缀属性列表
     */
    private static List<String> prohibitedExtensionList = new ArrayList<String>();

    /**
     * 从Web浏览器里，不进行扩展名验证的文件后缀属性列表
     */
    private static List<String> restrictionEscapePaths = new ArrayList<String>();

    /**
     * 服务器启动时，初始化。
     * @param config FilterConfig
     * @throws ServletException ServletException
     */
    public void init(FilterConfig config) throws ServletException {

        // 取得直接禁止访问扩展名列表。
        for (int i = 1;; i++) {
            String extension = PropertyUtil.getProperty(PROHIBITED_EXTENSION_PREFIX + i);

            if (extension == null) {
                break;
            }
            if (!extension.startsWith(".")) {
                extension = "." + extension;
            }
            if (log.isDebugEnabled()) {
                log.debug("prohibitedExtension:" + extension);
            }
            prohibitedExtensionList.add(extension);
        }
        // 不需要进行扩展名验证的后缀属性列表。
        for (int i = 1;; i++) {
            String extensionCheckEscapePath = PropertyUtil.getProperty(RESTRICTION_ESCAPE_PREFIX + i);

            // 没有路径，或者是数字结尾
            if (extensionCheckEscapePath == null) {
                break;
            }
            if (log.isDebugEnabled()) {
                log.debug("extensionCheckEscapePath:[" + extensionCheckEscapePath + "]");
            }
            restrictionEscapePaths.add(extensionCheckEscapePath);
        }
    }

    /**
     * 进行扩展名访问权限验证处理。
     * @param req ServletRequest
     * @param res ServletResponse
     * @param chain 过滤器链
     * @throws IOException I/O错误
     * @throws ServletException 例外
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse,
     *      javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
                                                                                    ServletException {
        String pathInfo = RequestUtil.getPathInfo(req);
        if (pathInfo != null && !restrictionEscapePaths.contains(pathInfo)) {

            String extension = StringUtil.getExtension(pathInfo);
            if (prohibitedExtensionList.contains(extension)) {
                log.info(extension);
                if (log.isDebugEnabled()) {
                    log.debug("requestURI[" + pathInfo + "] has prohibited extension");
                }

                throw new ProhibitedException();
            }
        }

        chain.doFilter(req, res);
    }

    /**
     * 过滤器销毁处理时被调用。<br>
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
        // 里面什么也不进行处理。
    }
}
