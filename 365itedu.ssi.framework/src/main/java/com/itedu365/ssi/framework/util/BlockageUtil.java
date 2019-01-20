/*
 * Copyright (C) 2013～2023 上海颐凡软件科技有限公司
 * Yfann Software Technology (Shanghai) Co.,LTD
 * All Rights Reserved.
 * 公司网址: www.yfann.com
 * 365IT教育网，成就您高品质的国际软件架构师之梦！
 * 平台网址:
 *         www.365itedu.com
 */

package com.itedu365.ssi.framework.util;

import java.util.ArrayList;
import java.util.List;

import com.itedu365.ssi.framework.bean.BlockUserAuthBean;

/**
 * 阻塞工具类。
 * @since V1.0
 * @version 版本1.0 2013.10.20
 * @author 颜廷吉
 */
public final class BlockageUtil {

    /**
     * 阻塞用户对象列表。
     */
    private static List<BlockUserAuthBean> blockUserAuthList = new ArrayList<BlockUserAuthBean>();

    /**
     * 阻塞静态类
     */
    private static BlockageUtil blockage = new BlockageUtil();

    /**
     * 私有构造函数
     */
    private BlockageUtil() {
    }

    /**
     * 取得阻塞类。
     * @return BlockageAuthction
     */
    public static BlockageUtil getBlockageObjectInstance() {
        return blockage;
    }

    /**
     * 取得阻塞用户对象列表。
     * @return blockUserAuthList blockUserAuthList
     */
    public static List<BlockUserAuthBean> getBlockUserAuthList() {
        return blockUserAuthList;
    }

    /**
     * 设定阻塞用户对象列表。
     * @param blockUserAuthList blockUserAuthList
     */
    public static void setBlockUserAuthList(List<BlockUserAuthBean> blockUserAuthList) {
        BlockageUtil.blockUserAuthList = blockUserAuthList;
    }

}
