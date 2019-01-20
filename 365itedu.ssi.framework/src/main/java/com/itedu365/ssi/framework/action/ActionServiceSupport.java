/*
 * Copyright (C) 2013～2023 上海颐凡软件科技有限公司
 * Yfann Software Technology (Shanghai) Co.,LTD
 * All Rights Reserved.
 * 公司网址: www.yfann.com
 * 365IT教育网，成就您高品质的国际软件架构师之梦！
 * 平台网址:
 *         www.365itedu.com
 */

package com.itedu365.ssi.framework.action;

import java.util.ArrayList;
import java.util.List;

import com.itedu365.ssi.framework.constants.FrameworkConst;
import com.itedu365.ssi.framework.message.ApplicationErrorMessage;
import com.itedu365.ssi.framework.message.ApplicationMessage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 应用程序Action服务支持类。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public class ActionServiceSupport extends ActionSupport {

    /**
     * 版本序列号
     */
    private static final long serialVersionUID = -3534262334100108904L;

    /**
     * 应用程序错误消息列表
     */
    private List<ApplicationErrorMessage> appErrorMessageList;

    /**
     * 应用程序消息列表
     */
    private List<ApplicationMessage> appMessageList;

    /**
     * 构造函数。
     */
    public ActionServiceSupport() {
        ActionContext ctx = ActionContext.getContext();
        ValueStack valueStack = ctx.getValueStack();
        appErrorMessageList = new ArrayList<ApplicationErrorMessage>();
        appMessageList = new ArrayList<ApplicationMessage>();
        valueStack.set(FrameworkConst.APP_MESSAGE_LIST_KEY, appMessageList);
        valueStack.set(FrameworkConst.APP_ERROR_MESSAGE_LIST_KEY, appErrorMessageList);
    }

    /**
     * 取得应用程序消息列表。
     * @return 应用程序消息列表
     */
    public List<ApplicationMessage> getAppMessageList() {
        return appMessageList;
    }

    /**
     * 设定应用程序消息列表。
     * @param applicationMessageList 应用程序消息列表
     */
    public void setAppMessageList(List<ApplicationMessage> appMessageList) {
        this.appMessageList = appMessageList;
    }

    /**
     * 取得应用程序错误消息列表。
     * @return 应用程序错误消息列表
     */
    public List<ApplicationErrorMessage> getAppErrorMessageList() {
        return appErrorMessageList;
    }

    /**
     * 设定应用程序错误消息列表。
     * @param appErrorMessageList
     * @param applicationErrorMessage 应用程序错误消息列表
     */
    public void setAppErrorMessage(List<ApplicationErrorMessage> appErrorMessage,
            List<ApplicationErrorMessage> appErrorMessageList) {
        this.appErrorMessageList = appErrorMessageList;
    }
}
