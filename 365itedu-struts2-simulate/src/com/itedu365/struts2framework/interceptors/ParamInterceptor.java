package com.itedu365.struts2framework.interceptors;

import java.util.Map;

import com.itedu365.struts2framework.action.ActionContext;
import com.itedu365.struts2framework.action.ValueStack;
import com.itedu365.struts2framework.interceptor.AbstractInterceptor;
import com.itedu365.struts2framework.invocation.ActionInvocation;

public class ParamInterceptor extends AbstractInterceptor {

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation invocation) {
        String result=null;
        Map<String, String[]> params = request.getParameterMap();
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        for (String key : params.keySet()) {
            valueStack.setValue(key.trim(), params.get(key)[0]);
        }

        System.out.println("ParamInterceptor Before");
        try {
            result = invocation.invoke();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ParamInterceptor After");
        return result;
    }

    @Override
    public void destroy() {

    }


}
