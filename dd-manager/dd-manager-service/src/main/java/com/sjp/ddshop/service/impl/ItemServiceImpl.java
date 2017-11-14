package com.sjp.ddshop.service.impl;

import com.sjp.ddshop.common.dto.Order;
import com.sjp.ddshop.common.dto.Page;
import com.sjp.ddshop.common.dto.Result;
import com.sjp.ddshop.common.util.IDUtils;
import com.sjp.ddshop.dao.TbItemCustomMapper;
import com.sjp.ddshop.dao.TbItemDescMapper;
import com.sjp.ddshop.dao.TbItemMapper;
import com.sjp.ddshop.pojo.po.TbItem;
import com.sjp.ddshop.pojo.po.TbItemDesc;
import com.sjp.ddshop.pojo.po.TbItemExample;
import com.sjp.ddshop.pojo.vo.TbItemCustom;
import com.sjp.ddshop.pojo.vo.TbItemQuery;
import com.sjp.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {


    @Autowired
    private TbItemMapper itemDao;
    @Autowired
    private TbItemCustomMapper itemCustomDao;
    @Autowired
    private TbItemDescMapper itemDescDao;


    @Override
    public TbItem getById(Long itemid) {
        TbItem tbItem= itemDao.selectByPrimaryKey(itemid);
        return tbItem;
    }


//    分页查询
@Override
public Result<TbItemCustom> listItemsByPage(Page page, Order order, TbItemQuery query) {
    Result<TbItemCustom> result = null;
    try {

        Map<String, Object> map = new HashMap<String,Object>();
        map.put("page", page);
        map.put("order", order);
        map.put("query", query);
        //1 创建一个响应参数实体类
        result = new Result<TbItemCustom>();
        //2 对total进行设值(符合条件的总记录数)
        int total = itemCustomDao.countItems(map);
        result.setTotal(total);
        //3 对rows进行设值(指定页码显示记录集合)
        List<TbItemCustom> list = itemCustomDao.listItemsByPage(map);
        result.setRows(list);
    }catch (Exception e) {
        e.printStackTrace();
    }
    return result;
}

    //新增商品
    @Override
    @Transactional     //加上注解之后变成事物方法
    public int addItem(TbItem tbItem, String content) {
        int i=0;
        try {
            //处理tb_item
            Long itemId=IDUtils.getItemId();
            tbItem.setId(itemId);
            tbItem.setStatus((byte) 2);
            tbItem.setCreated(new Date());
            tbItem.setUpdated(new Date());
            i=itemDao.insertSelective(tbItem);
            //处理tb_item_desc
            TbItemDesc desc =new TbItemDesc();
            desc.setItemId(itemId);
            desc.setItemDesc(content);
            desc.setCreated(new Date());
            desc.setUpdated(new Date());
            i+=itemDescDao.insertSelective(desc);
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    //批量删除（update）
    @Override
    public int updateItemsByIds(List<Long> ids) {

        int i=0;
        try {
            //准备商品status字段为3的对象
            TbItem record = new TbItem();
            record.setStatus((byte) 3);
            //创建更新模板--update tb_item set status=? where id in(?,?,?)
            TbItemExample exmaple = new TbItemExample();
            TbItemExample.Criteria criteria = exmaple.createCriteria();

            criteria.andIdIn(ids);

            i = itemDao.updateByExampleSelective(record, exmaple);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }



    //批量上架商品
    @Override
    public int updateItemsUpByIds(List<Long> ids) {
        int i=0;
        try {
            //准备商品status字段为2的对象
            TbItem record = new TbItem();
            record.setStatus((byte) 1);
            //创建新模板
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            //执行更新操作
            i = itemDao.updateByExampleSelective(record, example);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }



    //批量下架商品

    @Override
    public int updateItemDownByids(List<Long> ids) {
        int i=0;
        try {
            //准备商品status字段为2的对象
            TbItem record = new TbItem();
            record.setStatus((byte) 2);
            //创建新模板
            TbItemExample example = new TbItemExample();
            TbItemExample.Criteria criteria = example.createCriteria();
            criteria.andIdIn(ids);
            //执行更新操作
            i = itemDao.updateByExampleSelective(record, example);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
