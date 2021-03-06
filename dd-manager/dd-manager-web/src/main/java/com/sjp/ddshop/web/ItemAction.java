package com.sjp.ddshop.web;

import com.sjp.ddshop.common.dto.Order;
import com.sjp.ddshop.common.dto.Page;
import com.sjp.ddshop.common.dto.Result;
import com.sjp.ddshop.pojo.po.TbItem;
import com.sjp.ddshop.pojo.vo.TbItemCustom;
import com.sjp.ddshop.pojo.vo.TbItemQuery;
import com.sjp.ddshop.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Scope("prototype")
public class ItemAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ItemService itemService;

//    新增
    @ResponseBody
    @RequestMapping(value = "/item/{itemid}",method = RequestMethod.GET)
    public TbItem getById(@PathVariable("itemid") Long itemid){
        System.out.println(itemid);
        TbItem tbItem=itemService.getById(itemid);
        return tbItem;
    }




    //分页查询
    @ResponseBody
    @RequestMapping("/items")
    public Result<TbItemCustom> listItemsByPage(Page page, Order order, TbItemQuery query){
        Result<TbItemCustom> list = null;
        try {
            list = itemService.listItemsByPage(page,order,query);
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return list;
    }


//    删除(修改状态)
    @ResponseBody
    @RequestMapping("/items/batch")
    public int updateItemsByIds(@RequestParam("ids[]") List<Long> ids) {
        int i=0;
        try {
            i=itemService.updateItemsByIds(ids);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }


    // 商品上架

    @ResponseBody
    @RequestMapping("/items/batchUp")
    public int updataItemsUpByids(@RequestParam("ids[]") List<Long> ids) {
        int i=0;
        try {
            i = itemService.updateItemsUpByIds(ids);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return i;
    }


    //商品下架
    @ResponseBody
    @RequestMapping("/items/batchDown")
    public int  updataItemDownByids(@RequestParam("ids[]") List<Long> ids){
        int i=0;
        try {
            i = itemService.updateItemDownByids(ids);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }


    //保存商品
    @ResponseBody
    @RequestMapping("/item")
    public int saveItem(TbItem tbItem,String content){
        int i=0;
        try {
            i=itemService.addItem(tbItem,content);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }



}
