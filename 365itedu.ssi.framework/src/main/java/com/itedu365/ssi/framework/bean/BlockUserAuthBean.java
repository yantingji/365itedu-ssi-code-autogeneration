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
 * 业务阻塞处理类。
 * @since V1.0
 * @version 版本1.0 2013.11.22
 * @author 颜廷吉
 */
public class BlockUserAuthBean {

    /** 权限ID */
    private String authId;

    /** 用户 */
    private String userId;

    /** 权限URL */
    private String authURL;

    /** 状态码 */
    private String statusCd;

    /**
     * 设定权限ID。
     * @param authId String
     */
    public void setAuthId(String authId) {
        this.authId = authId;
    }

    /**
     * 取得权限ID。
     * @return authId String
     */
    public String getAuthId() {
        return authId;
    }

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
     * 设定权限URL。
     * @param authURL String
     */
    public void setAuthURL(String authURL) {
        this.authURL = authURL;
    }

    /**
     * 取得权限URL。
     * @return authURL String
     */
    public String getAuthURL() {
        return authURL;
    }

    /**
     * 设定状态码。
     * @param statusCd String
     */
    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    /**
     * 取得状态码。
     * @return statusCd String
     */
    public String getStatusCd() {
        return statusCd;
    }
}
