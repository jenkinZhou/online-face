package com.jenkin.onlineface.commons.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * @author ：jenkin
 * @date ：Created at 2020/3/13 12:07
 * @description：条件构造器，重写字符串转换方法
 * @modified By：
 * @version: 1.0
 */
public class MyUpdateWrapper<T> extends UpdateWrapper<T> {
    /**
     * 获取 columnName
     *
     * @param column
     */
    @Override
    protected String columnToString(String column) {
        return StringUtils.camelToUnderline(column);
    }
}
