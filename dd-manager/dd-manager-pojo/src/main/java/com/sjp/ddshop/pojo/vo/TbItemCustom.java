package com.sjp.ddshop.pojo.vo;

import com.sjp.ddshop.pojo.po.TbItem;

/*
   自定义商品显示类
 */
public class TbItemCustom extends TbItem{

    //分类名称
    private  String catName;

    //商品状态
    private  String statusName;

    //格式化时间
    private String updatedFormat;









    public String getUpdatedFormat() {
        return updatedFormat;
    }

    public void setUpdatedFormat(String updatedFormat) {
        this.updatedFormat = updatedFormat;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
