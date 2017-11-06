package com.sjp.ddshop.service.impl;

import com.sjp.ddshop.dao.TbItemMapper;
import com.sjp.ddshop.pojo.po.TbItem;
import com.sjp.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemDao;

    @Override
    public TbItem getById(Long itemid) {
        TbItem tbItem= itemDao.selectByPrimaryKey(itemid);
        return tbItem;
    }
}
