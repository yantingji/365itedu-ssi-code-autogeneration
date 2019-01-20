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

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.itedu365.ssi.framework.dao.QueryDAO;
import com.itedu365.ssi.framework.exception.IllegalClassTypeException;

/**
 * Ibatis用Query封装类。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public class QueryDAOiBatisSupport extends SqlMapClientDaoSupport implements QueryDAO {

    /**
     * 日志
     */
    private static Log log = LogFactory.getLog(QueryDAOiBatisSupport.class);

    /**
     * 执行查询SQL，返回指定类型的对象。
     * @param <E> 返回类型
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @param clazz 返回值的类型
     * @return SQL的执行结果
     */
    @SuppressWarnings("unchecked")
    public <E> E executeForObject(String sqlId, Object bindParams, Class<?> clazz) {

        if (log.isDebugEnabled()) {
            log.debug("executeForObject Start.");
        }

        // 因 为Ibatis框架中没有输出SQL参数的具体属性名称，所以在执行之前做一个补充。
        if (log.isDebugEnabled() && bindParams != null) {
            log.debug("Parameter: " + (ToStringBuilder.reflectionToString(bindParams)).toString());
        }

        // 取得SqlMapClientTemplate
        SqlMapClientTemplate sqlMapTemp = getSqlMapClientTemplate();

        // SQL执行
        Object obj = sqlMapTemp.queryForObject(sqlId, bindParams);

        // 因为Ibatis框架的执行结果的输出处理的比较优雅，在结果集输出的LOG里面，就不需要再进行补充输出了。
        // 如果还是用ToStringBuilder进行结果集输出，有一个缺点就是大数据的输出:会把blob等数据内容一起输出到LOG里面，
        // LOG会很快把磁盘写满，而框架的处理，只是输出大数据的地址。
        // if (log.isDebugEnabled() && bindParams != null) {
        // log.debug("Parameter: " + (ToStringBuilder.reflectionToString(obj)).toString());
        // }

        E rObj = null;
        try {
            if (clazz != null && obj != null) {
                rObj = (E) clazz.cast(obj);
            }
        } catch (ClassCastException e) {
            log.error(IllegalClassTypeException.ERROR_ILLEGAL_CLASS_TYPE);
            throw new IllegalClassTypeException(e);
        }

        if (log.isDebugEnabled()) {
            log.debug("executeForObject End.");
        }

        return rObj;
    }

    /**
     * 执行查询SQL，返回MAP类型对象。
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @return SQL的执行结果
     */
    public Map<String, Object> executeForMap(String sqlId, Object bindParams) {

        if (log.isDebugEnabled()) {
            log.debug("executeForMap Start.");
        }

        Map<String, Object> rObj = this.executeForObject(sqlId, bindParams, Map.class);

        if (log.isDebugEnabled()) {
            log.debug("executeForMap End.");
        }

        return rObj;
    }

    /**
     * 执行查询SQL，返回指定类型的对象数组。
     * @param <E> 返回类型
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @param clazz 返回值的类型
     * @return SQL的执行结果
     */
    @SuppressWarnings("unchecked")
    public <E> E[] executeForObjectArray(String sqlId, Object bindParams, Class<?> clazz) {

        if (log.isDebugEnabled()) {
            log.debug("executeForObjectArray Start.");
        }

        if (clazz == null) {
            log.error(IllegalClassTypeException.ERROR_ILLEGAL_CLASS_TYPE);
            throw new IllegalClassTypeException();
        }

        // 输出SQL参数的具体属性名称与参数具体值。
        if (log.isDebugEnabled() && bindParams != null) {
            log.debug("Parameter: " + (ToStringBuilder.reflectionToString(bindParams)).toString());
        }

        // 取得SqlMapClient
        SqlMapClientTemplate sqlMapTemp = getSqlMapClientTemplate();

        // SQL执行
        List<E> list = sqlMapTemp.queryForList(sqlId, bindParams);

        // 转换成数组
        E[] retArray = (E[]) Array.newInstance(clazz, list.size());
        try {
            list.toArray(retArray);
        } catch (ArrayStoreException e) {
            log.error(IllegalClassTypeException.ERROR_ILLEGAL_CLASS_TYPE);
            throw new IllegalClassTypeException(e);
        }

        if (log.isDebugEnabled()) {
            log.debug("executeForObjectArray End.");
        }

        return retArray;
    }

    /**
     * 执行查询SQL，返回指定范围期间的指定类型的对象数组。
     * @param <E> 返回类型
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @param clazz 返回值的类型
     * @param beginIndex 取得的开始索引值
     * @param maxCount 要取得的件数
     * @return SQL的执行结果
     */
    @SuppressWarnings("unchecked")
    public <E> E[] executeForObjectArray(String sqlId, Object bindParams, Class<?> clazz, int beginIndex, int maxCount) {

        if (log.isDebugEnabled()) {
            log.debug("executeForObjectArray Start.");
        }

        if (clazz == null) {
            log.error(IllegalClassTypeException.ERROR_ILLEGAL_CLASS_TYPE);
            throw new IllegalClassTypeException();
        }

        // 输出SQL参数的具体属性名称与参数具体值。
        if (log.isDebugEnabled() && bindParams != null) {
            log.debug("Parameter: " + (ToStringBuilder.reflectionToString(bindParams)).toString());
        }

        // 取得SqlMapClient
        SqlMapClientTemplate sqlMapTemp = getSqlMapClientTemplate();

        // 执行SQL
        List<E> list = sqlMapTemp.queryForList(sqlId, bindParams, beginIndex, maxCount);

        // 转成数组
        E[] retArray = (E[]) Array.newInstance(clazz, list.size());
        try {
            list.toArray(retArray);
        } catch (ArrayStoreException e) {
            log.error(IllegalClassTypeException.ERROR_ILLEGAL_CLASS_TYPE);
            throw new IllegalClassTypeException(e);
        }

        if (log.isDebugEnabled()) {
            log.debug("executeForObjectArray End.");
        }

        return retArray;
    }

    /**
     * 执行查询SQL，返回MAP类型数组。
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @return SQL的执行结果
     */
    public Map<String, Object>[] executeForMapArray(String sqlId, Object bindParams) {

        if (log.isDebugEnabled()) {
            log.debug("executeForMapArray Start.");
        }

        // 输出SQL参数的具体属性名称与参数具体值。
        if (log.isDebugEnabled() && bindParams != null) {
            log.debug("Parameter: " + (ToStringBuilder.reflectionToString(bindParams)).toString());
        }
        Map<String, Object>[] map = executeForObjectArray(sqlId, bindParams, Map.class);

        if (log.isDebugEnabled()) {
            log.debug("executeForMapArray End.");
        }

        return map;
    }

    /**
     * 执行查询SQL，返回指定范围期间的对象数组。
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @param beginIndex 取得的开始索引值
     * @param maxCount 要取得的件数
     * @return SQL的执行结果
     */
    public Map<String, Object>[] executeForMapArray(String sqlId, Object bindParams, int beginIndex, int maxCount) {

        if (log.isDebugEnabled()) {
            log.debug("executeForMapArray Start.");
        }
        // 输出SQL参数的具体属性名称与参数具体值。
        if (log.isDebugEnabled() && bindParams != null) {
            log.debug("Parameter: " + (ToStringBuilder.reflectionToString(bindParams)).toString());
        }

        Map<String, Object>[] map = executeForObjectArray(sqlId, bindParams, Map.class, beginIndex, maxCount);

        if (log.isDebugEnabled()) {
            log.debug("executeForMapArray End.");
        }

        return map;
    }

    /**
     * 执行查询SQL，返回指定类型的对象列表。
     * @param <E> 返回类型
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @return SQL的执行结果
     */
    @SuppressWarnings("unchecked")
    public <E> List<E> executeForObjectList(String sqlId, Object bindParams) {

        if (log.isDebugEnabled()) {
            log.debug("executeForObjectList Start.");
        }

        // 输出SQL参数的具体属性名称与参数具体值。
        if (log.isDebugEnabled() && bindParams != null) {
            log.debug("Parameter: " + (ToStringBuilder.reflectionToString(bindParams)).toString());
        }

        // 取得SqlMapClient
        SqlMapClientTemplate sqlMapTemp = getSqlMapClientTemplate();

        // 执行SQL
        List<E> list = sqlMapTemp.queryForList(sqlId, bindParams);

        if (log.isDebugEnabled()) {
            log.debug("executeForObjectList End.");
        }

        return list;
    }

    /**
     * 执行查询SQL，返回指定范围期间的指定类型的对象列表。
     * @param <E> 返回类型
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @param beginIndex 取得的开始索引值
     * @param maxCount 要取得的件数
     * @return SQL的执行结果
     */
    @SuppressWarnings("unchecked")
    public <E> List<E> executeForObjectList(String sqlId, Object bindParams, int beginIndex, int maxCount) {

        if (log.isDebugEnabled()) {
            log.debug("executeForObjectList Start.");
        }

        // 输出SQL参数的具体属性名称与参数具体值。
        if (log.isDebugEnabled() && bindParams != null) {
            log.debug("Parameter: " + (ToStringBuilder.reflectionToString(bindParams)).toString());
        }

        // SqlMapClientの取得
        SqlMapClientTemplate sqlMapTemp = getSqlMapClientTemplate();

        // SQLの実行：値の取得
        List<E> list = sqlMapTemp.queryForList(sqlId, bindParams, beginIndex, maxCount);

        if (log.isDebugEnabled()) {
            log.debug("executeForObjectList End.");
        }

        return list;
    }

    /**
     * 执行查询SQL，返回MAP类型的对象列表。
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @return SQL的执行结果
     */
    public List<Map<String, Object>> executeForMapList(String sqlId, Object bindParams) {

        if (log.isDebugEnabled()) {
            log.debug("executeForMapList Start.");
        }

        // 输出SQL参数的具体属性名称与参数具体值。
        if (log.isDebugEnabled() && bindParams != null) {
            log.debug("Parameter: " + (ToStringBuilder.reflectionToString(bindParams)).toString());
        }

        List<Map<String, Object>> mapList = executeForObjectList(sqlId, bindParams);

        if (log.isDebugEnabled()) {
            log.debug("executeForMapList End.");
        }

        return mapList;
    }

    /**
     * 执行查询SQL，返回指定范围期间的MAP类型的对象列表。
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @param beginIndex 取得的开始索引值
     * @param maxCount 要取得的件数
     * @return SQL的执行结果
     */
    public List<Map<String, Object>> executeForMapList(String sqlId, Object bindParams, int beginIndex, int maxCount) {

        if (log.isDebugEnabled()) {
            log.debug("executeForMapList Start.");
        }

        // 输出SQL参数的具体属性名称与参数具体值。
        if (log.isDebugEnabled() && bindParams != null) {
            log.debug("Parameter: " + (ToStringBuilder.reflectionToString(bindParams)).toString());
        }
        List<Map<String, Object>> mapList = executeForObjectList(sqlId, bindParams, beginIndex, maxCount);

        if (log.isDebugEnabled()) {
            log.debug("executeForMapList End.");
        }

        return mapList;
    }

}
