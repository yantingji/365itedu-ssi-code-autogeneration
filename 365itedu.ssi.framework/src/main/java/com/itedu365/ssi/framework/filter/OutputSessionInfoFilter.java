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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.itedu365.ssi.framework.constants.FrameworkConst;
import com.itedu365.ssi.framework.util.PropertyUtil;
import com.itedu365.ssi.framework.util.RequestUtil;

/**
 * 用户Session信息输出类。 <br>
 * 此类输出每次用户请求前与请求后session信息。<br>
 * 在大系统制造或者测试过程中，可以对输出的session信息进行前后对比。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public class OutputSessionInfoFilter implements Filter {

    /**
     * Bean中Get字符串
     */
    private static final String GET = "get";

    /**
     * 请求文件名称
     */
    private static final String REQUEST_LOG = "_Request.log";

    /**
     * 响应文件名称
     */
    private static final String RESPONSE_LOG = "_Response.log";
    private static final String LINE_SEPARATOR =System.getProperty("line.separator");

    /**
     * 4个半角空格
     */
    private static final String SPACE_4 = "    ";

    /**
     * 服务器启动时，初始化。
     * @param config FilterConfig
     * @throws ServletException ServletException
     */
    public void init(FilterConfig config) throws ServletException {

    }

    /**
     * 业务逻辑执行。
     * @param servletRequest ServletRequest
     * @param servletResponse ServletResponse
     * @param filterchain FilterChain
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterchain)
                                                                                                                 throws IOException,
                                                                                                                 ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String servletPath = request.getServletPath().replaceAll("/", "_");
        String actionExtention = RequestUtil.getActionExtention(request);
        if (actionExtention != null) {
            servletPath = servletPath.replaceAll(actionExtention, "");
        }
        String fileName = getCurrentTime() + servletPath;

        HttpSession session = request.getSession();

        // Request的Session内容信息输出调用。
        makeSessionInfoFile(fileName + REQUEST_LOG, session);

        filterchain.doFilter(servletRequest, servletResponse);

        // Response的Session内容信息输出调用。
        makeSessionInfoFile(fileName + RESPONSE_LOG, session);

    }

    /**
     * 过滤器销毁处理时被调用。<br>
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
        // 里面什么也不进行处理。
    }

    /**
     * Session信息文件做成处理。
     * @param fileName 文件名
     * @param session HttpSession
     */
    private static void makeSessionInfoFile(String fileName, HttpSession session) {

        // 取得session信息输出路径
        String userFilePath = PropertyUtil.getProperty("sessionInfoPath");

        // 目录做成
        File file = new File(userFilePath);
        if (!file.exists()) {
            file.mkdirs();
        }

        // 文件做成
        File sessionFile = new File(userFilePath + "/" + fileName);

        FileOutputStream out;
        try {
            out = new FileOutputStream(sessionFile);
            OutputStreamWriter writer = new OutputStreamWriter(out, "UTF-8");
            BufferedWriter bw = new BufferedWriter(writer);

            // 输出Session里所有属性信息
            Enumeration<?> attributeNames = session.getAttributeNames();
            while (attributeNames.hasMoreElements()) {
                String attributeName = (String) attributeNames.nextElement();

                StringBuffer strBuffer = new StringBuffer();

                // 输出属性内容
                getSessionContent(attributeName, session.getAttribute(attributeName), strBuffer, 0);
                bw.write(strBuffer.toString());
                bw.newLine();
            }

            bw.flush();
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Session内容输出处理。
     * @param attributeName 属性名
     * @param attributeContent 属性内容
     * @param strBuffer 字符串缓存
     * @param deepNum 递归深度层次
     */
    private static void getSessionContent(String attributeName, Object attributeContent, StringBuffer strBuffer,
            int deepNum) {
        deepNum++;
        if (attributeContent instanceof String) {
            strBuffer.append(getSpaceLength(deepNum) + attributeName + SPACE_4 + attributeContent
                    + LINE_SEPARATOR);
        } else if (attributeContent instanceof Integer) {
            strBuffer.append(getSpaceLength(deepNum) + attributeName + SPACE_4 + attributeContent.toString()
                    + LINE_SEPARATOR);
        } else if (attributeContent instanceof BigDecimal) {
            strBuffer.append(getSpaceLength(deepNum) + attributeName + SPACE_4 + attributeContent.toString()
                    + LINE_SEPARATOR);
        } else if (attributeContent instanceof Double) {
            strBuffer.append(getSpaceLength(deepNum) + attributeName + SPACE_4 + attributeContent.toString()
                    + LINE_SEPARATOR);
        } else if (attributeContent instanceof Float) {
            strBuffer.append(getSpaceLength(deepNum) + attributeName + SPACE_4 + attributeContent.toString()
                    + LINE_SEPARATOR);
        } else if (attributeContent instanceof Date) {
            strBuffer.append(getSpaceLength(deepNum) + attributeName + SPACE_4 + attributeContent.toString()
                    + LINE_SEPARATOR);
        } else if (attributeContent instanceof Boolean) {
            strBuffer.append(getSpaceLength(deepNum) + attributeName + SPACE_4 + attributeContent.toString()
                    + LINE_SEPARATOR);
        } else if (attributeContent instanceof Byte) {
            strBuffer.append(getSpaceLength(deepNum) + attributeContent.toString() + LINE_SEPARATOR);
        } else if (attributeContent instanceof Map) {
            getMapContent(attributeName, (Map<?, ?>) attributeContent, strBuffer, deepNum);
        } else if (attributeContent instanceof Hashtable) {
            getMapContent(attributeName, (Hashtable<?, ?>) attributeContent, strBuffer, deepNum);
        } else if (attributeContent instanceof ArrayList) {
            getListContent(attributeName, (ArrayList<?>) attributeContent, strBuffer, deepNum);
        } else if (attributeContent instanceof Vector) {
            getListContent(attributeName, (List<?>) attributeContent, strBuffer, deepNum);
        } else if (attributeContent != null) {
            getBeanContents(attributeContent, strBuffer, deepNum);
        }
    }

    /**
     * Session属性为Map内容的输出处理。
     * @param attributeName 属性名
     * @param attributeContent Map属性
     * @param strBuffer 字符串缓存
     * @param deepNum 递归深度层次
     */
    private static void getMapContent(String attributeName, Map<?, ?> attributeContent, StringBuffer strBuffer,
            int deepNum) {
        for (Iterator<?> it = attributeContent.keySet().iterator(); it.hasNext();) {
            String key = (String) it.next();
            strBuffer.append(getSpaceLength(deepNum) + attributeName + SPACE_4 + key + SPACE_4);
            getSessionContent(key, attributeContent.get(key), strBuffer, deepNum);
        }
    }

    /**
     * Session属性为List内容的输出处理。
     * @param attributeName 属性名
     * @param attributeContent List属性
     * @param strBuffer 字符串缓存
     * @param deepNum 递归深度层次
     */
    private static void getListContent(String attributeName, List<?> attributeContent, StringBuffer strBuffer,
            int deepNum) {

        if (attributeContent == null) {
            return;
        }
        for (int i = 0; i < attributeContent.size(); i++) {
            strBuffer.append(getSpaceLength(deepNum) + attributeName + SPACE_4);
            String tmpAttributeName = "";
            if (attributeContent.get(i) != null) {
                tmpAttributeName = attributeContent.get(i).toString();
            }
            getSessionContent(tmpAttributeName, attributeContent.get(i), strBuffer, deepNum);
        }

    }

    /**
     * Session属性为Bean内容的输出处理。
     * @param objectClass 对象Bean
     * @param strBuffer 字符串缓存
     * @param deepNum 递归深度层次
     */
    private static void getBeanContents(Object objectClass, StringBuffer strBuffer, int deepNum) {
        Class<?> clazz;
        String className = objectClass.getClass().getName();
        Object beanObject = objectClass;
        try {
            clazz = Class.forName(className);
            Method[] method = clazz.getDeclaredMethods();

            for (int i = 0; i < method.length; i++) {
                try {
                    method[i].setAccessible(true);
                    String methodName = method[i].getName();
                    Object object = null;
                    if (methodName != null && GET.equals(methodName.substring(0, GET.length()))) {
                        object = method[i].invoke(beanObject, new Object[] {});
                    }
                    getSessionContent(methodName, object, strBuffer, deepNum);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 取得递归层次中，每行开头空格数。
     * @param deepNum 递归层次深度
     * @return 开头空格字符串
     */
    private static String getSpaceLength(int deepNum) {
        String tmpStr = "";
        for (int i = 0; i < deepNum; i++) {
            tmpStr = tmpStr + SPACE_4;
        }
        return tmpStr;

    }

    /**
     * 取得当前时间。
     * @return 当前时间
     */
    private static String getCurrentTime() {

        SimpleDateFormat sdf = new SimpleDateFormat(FrameworkConst.YYYYMMDDHHMMSS);
        String time = sdf.format(new Date());

        return time;
    }

    /**
     * 取得系统action扩展名，默认为.do。
     * @param request 请求信息
     * @return 系统atcion扩展名
     */
    public static String getActionExtention(HttpServletRequest request) {
        String actionExtention = (String) request.getAttribute("javax.servlet.forward.servlet_path");
        if (actionExtention != null) {
            actionExtention = actionExtention.substring(actionExtention.lastIndexOf('.'), actionExtention.length());
            if (actionExtention.indexOf("?") > 0) {
                actionExtention = actionExtention.substring(0, actionExtention.indexOf("?"));
            }
        }
        if (actionExtention == null) {
            actionExtention = ".do";
        }
        return actionExtention;
    }

}
