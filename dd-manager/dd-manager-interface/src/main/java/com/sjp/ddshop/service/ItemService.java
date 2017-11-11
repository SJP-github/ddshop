package com.sjp.ddshop.service;

import com.sjp.ddshop.common.dto.Order;
import com.sjp.ddshop.common.dto.Page;
import com.sjp.ddshop.common.dto.Result;
import com.sjp.ddshop.pojo.po.TbItem;
import com.sjp.ddshop.pojo.vo.TbItemCustom;
import com.sjp.ddshop.pojo.vo.TbItemQuery;

import java.util.List;
import java.util.Map;

public interface ItemService {

    TbItem getById(Long itemid);

    //List<TbItem> listItems();

    //分页查询
    Result<TbItemCustom> listItemsByPage(Page page, Order order, TbItemQuery query);

    int updateItemsByIds(List<Long> ids);

    int updateItemsUpByIds(List<Long> ids);

    int updateItemDownByids(List<Long> ids);
}
