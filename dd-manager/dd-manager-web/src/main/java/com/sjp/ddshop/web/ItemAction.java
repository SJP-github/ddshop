package com.sjp.ddshop.web;

import com.sjp.ddshop.common.dto.Page;
import com.sjp.ddshop.common.dto.Result;
import com.sjp.ddshop.pojo.po.TbItem;
import com.sjp.ddshop.pojo.vo.TbItemCustom;
import com.sjp.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Scope("prototype")
public class ItemAction {


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
    public Result<TbItemCustom> listItemsByPage(Page page){
        Result<TbItemCustom> list = null;
        try {
            list = itemService.listItemsByPage(page);
        }catch (Exception e) {
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
            e.printStackTrace();
        }
        return i;
    }



}
