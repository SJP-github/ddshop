package com.sjp.ddshop.service.impl;

import com.sjp.ddshop.common.dto.Page;
import com.sjp.ddshop.common.dto.Result;
import com.sjp.ddshop.dao.TbItemCustomMapper;
import com.sjp.ddshop.dao.TbItemMapper;
import com.sjp.ddshop.pojo.po.TbItem;
import com.sjp.ddshop.pojo.vo.TbItemCustom;
import com.sjp.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {


    @Autowired
    private TbItemMapper itemDao;
    @Autowired
    private TbItemCustomMapper itemCustomDao;

    @Override
    public TbItem getById(Long itemid) {
        TbItem tbItem= itemDao.selectByPrimaryKey(itemid);
        return tbItem;
    }


//    分页查询
@Override
public Result<TbItemCustom> listItemsByPage(Page page) {
    Result<TbItemCustom> result = null;
    try {
        //1 创建一个响应参数实体类
        result = new Result<TbItemCustom>();
        //2 对total进行设值(符合条件的总记录数)
        int total = itemCustomDao.countItems();
        result.setTotal(total);
        //3 对rows进行设值(指定页码显示记录集合)
        List<TbItemCustom> list = itemCustomDao.listItemsByPage(page);
        result.setRows(list);
    }catch (Exception e) {
        e.printStackTrace();
    }
    return result;
}

   /* @Override
    public List<TbItem> listItems() {
        List<TbItem> list=null;
        try {
            list=itemDao.selectByExample(null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }*/
}
