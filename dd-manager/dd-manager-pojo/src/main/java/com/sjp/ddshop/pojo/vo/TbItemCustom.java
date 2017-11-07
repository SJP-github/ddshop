package com.sjp.ddshop.pojo.vo;

import com.sjp.ddshop.pojo.po.TbItem;

/*
   自定义商品显示类
 */
public class TbItemCustom extends TbItem{

    private  String catName;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
