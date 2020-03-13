package com.jenkin.onlineface.commons.http;

import lombok.Data;

import java.util.List;

/**
 * @author ：jenkin
 * @date ：Created at 2020/3/13 10:24
 * @description：分页数据封装类
 * @modified By：
 * @version: 1.0
 */

@Data
public class PageData<T> {

    private int pageSize;

    private int pageNum;

    private int count;

    private List<T> result;

}
