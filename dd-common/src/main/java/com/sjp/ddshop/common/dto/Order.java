package com.sjp.ddshop.common.dto;

import java.util.ArrayList;
import java.util.List;

/*
   排序，组合排序
 */

public class Order {

    //id
    private String sort;
    //asc
    private String order;

    //private  String orderParams;

    public List<String> getOrderParams() {
        //将sort,order字符串进行分割
        String[] sorts = this.sort.split(",");
        String[] orders = this.order.split(",");
        //
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < sorts.length; i++) {

            String temp = sorts[i] + " " + orders[i];
            list.add(temp);
        }

        return list;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
