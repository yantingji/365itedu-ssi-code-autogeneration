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

import java.util.List;
import java.util.Map;

/**
 * Query封装接口。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public interface QueryDAO {

    /**
     * 执行查询SQL，返回指定类型的对象。
     * @param <E> 返回类型
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @param clazz 返回值的类型
     * @return SQL的执行结果
     */
    <E> E executeForObject(String sqlId, Object bindParams, Class<?> clazz);

    /**
     * 执行查询SQL，返回MAP类型对象。
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @return SQL的执行结果
     */
    Map<String, Object> executeForMap(String sqlId, Object bindParams);

    /**
     * 执行查询SQL，返回指定类型的对象数组。
     * @param <E> 返回类型
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @param clazz 返回值的类型
     * @return SQL的执行结果
     */
    <E> E[] executeForObjectArray(String sqlId, Object bindParams, Class<?> clazz);

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
    <E> E[] executeForObjectArray(String sqlId, Object bindParams, Class<?> clazz, int beginIndex, int maxCount);

    /**
     * 执行查询SQL，返回MAP类型数组。
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @return SQL的执行结果
     */
    Map<String, Object>[] executeForMapArray(String sqlId, Object bindParams);

    /**
     * 执行查询SQL，返回指定范围期间的对象数组。
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @param beginIndex 取得的开始索引值
     * @param maxCount 要取得的件数
     * @return SQL的执行结果
     */
    Map<String, Object>[] executeForMapArray(String sqlId, Object bindParams, int beginIndex, int maxCount);

    /**
     * 执行查询SQL，返回指定类型的对象列表。
     * @param <E> 返回类型
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @return SQL的执行结果
     */
    <E> List<E> executeForObjectList(String sqlId, Object bindParams);

    /**
     * 执行查询SQL，返回指定范围期间的指定类型的对象列表。
     * @param <E> 返回类型
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @param beginIndex 取得的开始索引值
     * @param maxCount 要取得的件数
     * @return SQL的执行结果
     */
    <E> List<E> executeForObjectList(String sqlId, Object bindParams, int beginIndex, int maxCount);

    /**
     * 执行查询SQL，返回MAP类型的对象列表。
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @return SQL的执行结果
     */
    List<Map<String, Object>> executeForMapList(String sqlId, Object bindParams);

    /**
     * 执行查询SQL，返回指定范围期间的MAP类型的对象列表。
     * @param sqlId 执行SQL的Id
     * @param bindParams SQL的参数
     * @param beginIndex 取得的开始索引值
     * @param maxCount 要取得的件数
     * @return SQL的执行结果
     */
    List<Map<String, Object>> executeForMapList(String sqlId, Object bindParams, int beginIndex, int maxCount);

}
