/*
 * Copyright (C) 2013～2023 上海颐凡软件科技有限公司
 * Yfann Software Technology (Shanghai) Co.,LTD  
 * All Rights Reserved.
 * 公司网址: www.yfann.com
 * 365IT教育网，成就您高品质的国际软件架构师之梦！
 * 平台网址:
 *         www.365itedu.com
 */

package com.itedu365.ssi.framework;


/**
 * 用户自定义输入验证接口。 UEC:User Extend Checker.
 * @param <P> 所要验证的Bean类
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public interface CheckerUEC<P> extends Checker<P> {
    /**
     * 验证处理。
     * @param enventMethod 验证出错后所要返回的结果画面
     * @throws Exception 验证异常类
     */
    void checkerUEC(String enventMethod) throws Exception;

}
