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

import com.itedu365.ssi.framework.dao.UpdateDAO;

/**
 * Ibatis用UpdateDAO封装类。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public class UpdateDAOiBatisSupport extends SqlMapClientDaoSupport implements UpdateDAO {

    /**
     * 日志
     */
    static Log log = LogFactory.getLog(UpdateDAOiBatisSupport.class);

    /**
     * 根据指定的sqlId，执行SQL，返回结果件数。<br/>
     * 执行SQL种类有「insert, update delete」。
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @return SQL的执行结果
     */
    public int execute(String sqlId, Object bindParams) {

        if (log.isDebugEnabled()) {
            log.debug("execute Start.");
        }

        // 取得SqlMapClient
        SqlMapClientTemplate sqlMapTemp = getSqlMapClientTemplate();

        // 执行SQL
        int row = sqlMapTemp.update(sqlId, bindParams);

        if (log.isDebugEnabled()) {
            log.debug("execute End. success count:" + row);
        }
        return row;
    }

}
