package com.itedu365.struts2framework.action;

import javax.servlet.http.HttpServletRequest;

import com.itedu365.struts2framework.filter.PrepareOperations;
import com.itedu365.struts2framework.invocation.ActionInvocation;

public class ActionProxy {
    private HttpServletRequest request;

    private PrepareOperations prepareOperations;

    public ActionProxy(HttpServletRequest request, PrepareOperations prepareOperations) {
        this.request = request;
        this.prepareOperations = prepareOperations;
    }

    public String execute() throws Exception {
        String actionName = (String) request.getAttribute("actionName");
        request.setAttribute("actionConfig", prepareOperations.getActionConfig(actionName));
       return (new ActionInvocation(prepareOperations.getInterceptors(), request)).invoke();
    }
}
