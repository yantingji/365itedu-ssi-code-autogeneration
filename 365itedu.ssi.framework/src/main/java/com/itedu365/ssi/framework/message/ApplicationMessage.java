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
 * 应用程序业务消息类。
 * @since 1.0
 * @author 颜廷吉
 */
public class ApplicationMessage {

    /**
     * 消息编码
     */
    private String code = "";

    /**
     * 消息参数数组
     */
    private String[] param;

    /**
     * 消息内容
     */
    private String message = "";

    /**
     * 构造函数，只使用编码的情况。 <br/>
     * 根据编码，在属性文件取得内容。
     * @param code 编码
     */
    public ApplicationMessage(String code) {
        this.code = code;
    }

    /**
     * 构造函数，直接使用消息内容的情况。 <br/>
     * 这种情况下，编码一般为空，直接使用消息内容。
     * @param code 编码
     * @param message 消息内容
     */
    public ApplicationMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 构造函数，直接使用消息内容的情况。 <br/>
     * 这种情况下，编码一般为空，直接使用消息内容。
     * @param code 编码
     * @param param 消息参数
     */
    public ApplicationMessage(String code, String[] param) {
        this.code = code;
        this.param = param;
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
     * 取得消息参数数组。
     * @return 消息参数数组
     */
    public String[] getParam() {
        return param;
    }

    /**
     * 设定消息参数数组。
     * @param param 消息参数数组
     */
    public void setParam(String[] param) {
        this.param = param;
    }

    /**
     * 取得消息内容。
     * @return 消息内容
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设定消息内容。
     * @param message 消息内容
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
