/*
 * Copyright (C) 2013～2023 上海颐凡软件科技有限公司
 * Yfann Software Technology (Shanghai) Co.,LTD  
 * All Rights Reserved.
 * 公司网址: www.yfann.com
 * 365IT教育网，成就您高品质的国际软件架构师之梦！
 * 平台网址:
 *         www.365itedu.com
 */

package com.itedu365.ssi.framework.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息类。
 * @since V1.0
 * @version 版本1.0 2013.11.22
 * @author 颜廷吉
 */
public class UIOBean {

    /** 用户 */
    private String userId;

    /** 登陆次数 */
    private Integer loginTimes;

    /** 最近登陆时间 */
    private String lastLoginTime;

    /** 用户名 */
    private String userName;

    /** 权限列表 */
    private List<AuthBean> authBeanList = new ArrayList<AuthBean>();

    /**
     * 设定用户。
     * @param userId String
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 取得用户。
     * @return userId String
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设定登陆次数。
     * @param loginTimes Integer
     */
    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    /**
     * 取得登陆次数。
     * @return loginTimes Integer
     */
    public Integer getLoginTimes() {
        return loginTimes;
    }

    /**
     * 设定最近登陆时间。
     * @param lastLoginTime String
     */
    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 取得最近登陆时间。
     * @return lastLoginTime String
     */
    public String getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设定用户名。
     * @param userName String
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 取得用户名。
     * @return userName String
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设定权限列表。
     * @param authBeanList List<AuthBean>
     */
    public void setAuthBeanList(List<AuthBean> authBeanList) {
        this.authBeanList = authBeanList;
    }

    /**
     * 取得权限列表。
     * @return authBeanList List<AuthBean>
     */
    public List<AuthBean> getAuthBeanList() {
        return authBeanList;
    }
}
