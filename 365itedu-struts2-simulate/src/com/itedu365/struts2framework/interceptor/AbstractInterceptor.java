package com.itedu365.struts2framework.interceptor;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractInterceptor implements Interceptor{

    protected HttpServletRequest request;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

}
