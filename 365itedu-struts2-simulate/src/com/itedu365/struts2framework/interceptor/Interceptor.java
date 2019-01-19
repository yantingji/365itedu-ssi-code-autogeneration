package com.itedu365.struts2framework.interceptor;

import javax.servlet.http.HttpServletRequest;

import com.itedu365.struts2framework.invocation.ActionInvocation;


public interface Interceptor {

    public void init();

    public String intercept(ActionInvocation invocation);

    public void setRequest(HttpServletRequest request);

    public void destroy();
}
