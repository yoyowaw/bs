package com.youzhihua.bs.utils;

import java.util.List;

/**
 * 封装分页属性
 */
public class PageBean<T> {

    private int currentPage;//当前页码
    private int pageSize;//每页显示的分页数
    private int total;//总记录数
    private List<T> rows;//当前页需要展示的数据集合

    public PageBean(int currentPage, int pageSize, int total) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.total = total;
    }

    public PageBean() {
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
