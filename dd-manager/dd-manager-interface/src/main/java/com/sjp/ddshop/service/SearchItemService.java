package com.sjp.ddshop.service;

import com.sjp.ddshop.pojo.vo.TbSearchItemResult;

public interface SearchItemService {
//    导入所有商品到索引库
    boolean importAllItems();
    //全文检索
    TbSearchItemResult search(String keyword, Integer page, int i);
}
