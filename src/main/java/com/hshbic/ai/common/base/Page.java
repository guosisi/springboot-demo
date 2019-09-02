package com.hshbic.ai.common.base;

import java.io.Serializable;

public class Page implements Serializable {
    private Integer pageNo; // 当前页码
    private Integer pageSize = 20; // 每页条数
    private Integer pages; // 总页数
    private Integer total; // 数据总条数

    public Page(){}

    public Page(Integer pageNo, Integer pageSize, Integer total) {
        this.pageSize = pageSize == null ? 20 : pageSize;
        this.total = total;
        this.pages = (total % pageSize == 0) ? total / pageSize : total / pageSize + 1;
        this.pageNo = pageNo > pages ? pages : pageNo;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void getPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
