/*
 * Copyright (C) 2013～2023 上海颐凡软件科技有限公司
 * Yfann Software Technology (Shanghai) Co.,LTD  
 * All Rights Reserved.
 * 公司网址: www.yfann.com
 * 365IT教育网，成就您高品质的国际软件架构师之梦！
 * 平台网址:
 *         www.365itedu.com
 */

package com.itedu365.ssi.framework.message;

/**
 * 应用程序业务错误消息类。
 * @since 1.0
 * @author 颜廷吉
 */
public class ApplicationErrorMessage {

    /**
     * 消息编码
     */
    private String code = "";

    /**
     * 光标位置初始化项目
     */
    private String[] itemIds;

    /**
     * 消息参数数组
     */
    private String[] params;

    /**
     * 构造函数。 <br/>
     * 根据编码，在属性文件取得内容。
     * @param code 编码
     * @param itemIds 光标位置初始化项目
     * @param param 消息参数
     */
    public ApplicationErrorMessage(String code) {
        this.code = code;
    }

    /**
     * 构造函数。 <br/>
     * 根据编码，在属性文件取得内容。
     * @param code 编码
     * @param itemIds 消息参数
     */
    public ApplicationErrorMessage(String code, String[] itemIds) {
        this.code = code;
        this.itemIds = itemIds;
    }

    /**
     * 构造函数。 <br/>
     * 根据编码，在属性文件取得内容。
     * @param code 编码
     * @param itemIds 数组参数的第一个为光标位置初始化项目；如果是输入项，那么相应的所有背景色变成红色。
     * @param param 消息参数
     */
    public ApplicationErrorMessage(String code, String[] itemIds, String[] params) {
        this.code = code;
        this.itemIds = itemIds;
        this.params = params;
    }

    /**
     * 取得消息编码。
     * @return 消息编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设定消息编号。
     * @param code 消息编号
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 取得光标位置初始化项目。
     * @return 光标位置初始化项目
     */
    public String[] getItemIds() {
        return itemIds;
    }

    /**
     * 设定光标位置初始化项目。
     * @param itemIds 光标位置初始化项目
     */
    public void setItemIds(String[] itemIds) {
        this.itemIds = itemIds;
    }

    /**
     * 取得消息参数数组。
     * @return 消息参数数组
     */
    public String[] getParams() {
        return params;
    }

    /**
     * 设定消息参数数组。
     * @param param 消息参数数组
     */
    public void setParams(String[] params) {
        this.params = params;
    }

}
