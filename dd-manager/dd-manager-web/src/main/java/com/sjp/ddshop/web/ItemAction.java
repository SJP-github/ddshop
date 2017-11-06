package com.sjp.ddshop.web;

import com.sjp.ddshop.pojo.po.TbItem;
import com.sjp.ddshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
public class ItemAction {

    @Autowired
    private ItemService itemService;

    @ResponseBody
    @RequestMapping(value = "/item/{itemid}",method = RequestMethod.GET)
    public TbItem getById(@PathVariable("itemid") Long itemid){
        System.out.println(itemid);
        return itemService.getById(itemid);
    }
}
