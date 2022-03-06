package com.fc.vo;

import java.util.List;

/*
分页信息实体类，包含一些通用的参数
 */
public class PageInfo<T> {
    private int pageCount;
    private int totalCount;
    private int pageSize;
    private  int pageNo;
    //当前页中的所有数据
    private List<T> list;

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageCount=" + pageCount +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                ", list=" + list +
                '}';
    }

    public PageInfo(int totalCount, int pageSize, int pageNo, List<T> list) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.list = list;
        //正好放下
        if (totalCount%pageSize==0){
            this.pageCount=totalCount/pageSize;
        }else {
            //放不下
            this.pageCount=totalCount/pageSize+1;
        }
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totaiCount) {
        this.totalCount = totaiCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PageInfo() {
    }
}
