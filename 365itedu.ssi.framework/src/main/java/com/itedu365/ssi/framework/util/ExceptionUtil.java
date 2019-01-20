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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 异常处理工具类。
 * <p>
 * 本类功能可以把例外中的堆栈轨迹内容全部输出。<br>
 * 本功能可以递归的把例外内容输出。 下面是使用本类的例子。<br>
 * <strong>ExceptionUtil的使用例子</strong><br>
 * <code><pre>
 *  ・・・
 *  try {
 *     ・・・
 *  } catch (Exception e) {
 *      // 例外内容全部输出
 *      log.error("error-message", ExceptionUtil.getStackTrace(e));
 *  }
 *  ・・・
 * </pre></code>
 * </p>
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public final class ExceptionUtil {

    /**
     * 日志类
     */
    private static Log log = LogFactory.getLog(ExceptionUtil.class);

    /**
     * 只有ServletException例外的时候，堆栈轨迹处理是用不同的方法处理的，为了区别定义此字符串。
     */
    private static final String SERVLET_EXCEPTION_NAME = "javax.servlet.ServletException";

    /**
     * ServletException发生的时候，使用的方法名称 返回Servlet例外所引起的最原始的例外
     */
    private static final String GET_ROOT_CAUSE = "getRootCause";

    /**
     * 取得指定后的例外堆栈轨迹。
     * <p>
     * 递归取得例外堆栈轨迹内容。只是，getRootCause()抛出的例外，由ServletException来处理。
     * </p>
     * @param throwable ��O
     * @return 递归内容
     */
    @SuppressWarnings("unchecked")
    public static String getStackTrace(Throwable throwable) {
        StringBuilder sb = new StringBuilder();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while (throwable != null) {
            baos.reset();
            throwable.printStackTrace(new PrintStream(baos));
            sb.append(baos.toString());

            // 从throwable里面，取出Class实例
            @SuppressWarnings("rawtypes")
            Class throwableClass = throwable.getClass();

            // ServletException 的时候使用getRootCause
            if (SERVLET_EXCEPTION_NAME.equals(throwableClass.getName())) {
                try {
                    // throwable = ((ServletException) throwable).getRootCause()
                    // 从Class对象里面取得方法名后执行。
                    Method method = throwableClass.getMethod(GET_ROOT_CAUSE);
                    throwable = (Throwable) method.invoke(throwable);
                } catch (NoSuchMethodException e) {
                    log.error(e.getMessage());
                    throwable = null;
                } catch (IllegalAccessException e) {
                    log.error(e.getMessage());
                    throwable = null;
                } catch (InvocationTargetException e) {
                    log.error(e.getMessage());
                    throwable = null;
                }

            } else {
                throwable = throwable.getCause();
            }
        }
        return sb.toString();
    }

}
