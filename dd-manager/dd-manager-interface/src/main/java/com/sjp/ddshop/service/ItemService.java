package com.sjp.ddshop.service;

import com.sjp.ddshop.common.dto.Page;
import com.sjp.ddshop.common.dto.Result;
import com.sjp.ddshop.pojo.po.TbItem;
import com.sjp.ddshop.pojo.vo.TbItemCustom;

import java.util.List;

public interface ItemService {

    TbItem getById(Long itemid);

    //List<TbItem> listItems();

    //分页查询
    Result<TbItemCustom> listItemsByPage(Page page);
}
