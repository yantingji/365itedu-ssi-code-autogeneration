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

/**
 * 权限Bean类。
 * @since V1.0
 * @version 版本1.0 2013.11.20
 * @author 颜廷吉
 */
public class AuthBean {
    /** 权限ID */
    private String authId;

    /** 权限URL */
    private String authURL;

    /**
     * 取得权限ID。
     * @return String authId
     */
    public String getAuthId() {
        return authId;
    }

    /**
     * 设定权限ID。
     * @param authId String
     */
    public void setAuthId(String authId) {
        this.authId = authId;
    }

    /**
     * 取得权限URL。
     * @return String authURL
     */
    public String getAuthURL() {
        return authURL;
    }

    /**
     * 设定权限URL。
     * @param authURL String
     */
    public void setAuthURL(String authURL) {
        this.authURL = authURL;
    }

}
