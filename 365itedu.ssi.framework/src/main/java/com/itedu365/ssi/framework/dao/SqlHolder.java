/*
 * Copyright (C) 2013～2023 上海颐凡软件科技有限公司
 * Yfann Software Technology (Shanghai) Co.,LTD  
 * All Rights Reserved.
 * 公司网址: www.yfann.com
 * 365IT教育网，成就您高品质的国际软件架构师之梦！
 * 平台网址:
 *         www.365itedu.com
 */

package com.itedu365.ssi.framework.dao;

/**
 * SQL查询条件类。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public class SqlHolder {

    /**
     * SQLID
     */
    protected String sqlId;

    /**
     * SQL参数
     */
    protected Object bindParams;

    /**
     * 构造函数。
     * @param sqlId SQLID
     * @param bindParams SQL参数
     */
    public SqlHolder(String sqlId, Object bindParams) {
        this.sqlId = sqlId;
        this.bindParams = bindParams;
    }

    /**
     * 取得SQLID。
     * @return SQLID
     */
    public String getSqlId() {
        return sqlId;
    }

    /**
     * 取得SQL的参数。
     * @return SQL参数
     */
    public Object getBindParams() {
        return bindParams;
    }

}
