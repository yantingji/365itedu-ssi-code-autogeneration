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
 * StoredProcedureDAO封装接口。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public interface StoredProcedureDAO {

    /**
     * 执行指定SQLID的存储过程。
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     */
    void executeForObject(String sqlId, Object bindParams);
}
