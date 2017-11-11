package com.sjp.ddshop.common.dto;

/*
   分页：
   param: page  当前页
   param: rows  每页数据量
 */
public class Page {

//    当前页
    private int page;
//    每页显示的条数
    private int rows;
//    偏移量（每页的第一条数据的索引值）
    //private  int offset;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getOffset() {
        return (page-1)*rows;
    }


}
