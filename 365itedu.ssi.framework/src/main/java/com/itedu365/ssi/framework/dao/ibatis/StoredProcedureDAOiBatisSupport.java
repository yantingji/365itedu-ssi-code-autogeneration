/*
 * Copyright (C) 2013～2023 上海颐凡软件科技有限公司
 * Yfann Software Technology (Shanghai) Co.,LTD
 * All Rights Reserved.
 * 公司网址: www.yfann.com
 * 365IT教育网，成就您高品质的国际软件架构师之梦！
 * 平台网址:
 *         www.365itedu.com
 */

package com.itedu365.ssi.framework.dao.ibatis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.itedu365.ssi.framework.dao.StoredProcedureDAO;

/**
 * Ibatis用Procedure封装类。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public class StoredProcedureDAOiBatisSupport extends SqlMapClientDaoSupport implements StoredProcedureDAO {

    /**
     * 日志
     */
    private static Log log = LogFactory.getLog(StoredProcedureDAOiBatisSupport.class);

    /**
     * 执行过程处理。
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     */
    public void executeForObject(String sqlId, Object bindParams) {

        if (log.isDebugEnabled()) {
            log.debug("executeForObject Start.");
        }

        // 取得SqlMapClient
        SqlMapClientTemplate sqlMapTemp = getSqlMapClientTemplate();

        // SQL执行
        sqlMapTemp.queryForObject(sqlId, bindParams);

        if (log.isDebugEnabled()) {
            log.debug("executeForObject End.");
        }

    }

}
