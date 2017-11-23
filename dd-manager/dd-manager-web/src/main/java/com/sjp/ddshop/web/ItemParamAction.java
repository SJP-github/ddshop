package com.sjp.ddshop.web;

import com.sjp.ddshop.common.dto.Page;
import com.sjp.ddshop.common.dto.Result;
import com.sjp.ddshop.pojo.po.TbItemParam;
import com.sjp.ddshop.pojo.vo.TbItemParamCustom;
import com.sjp.ddshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemParamAction {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemParamService itemParamService;

    @ResponseBody
    @RequestMapping("/itemParams")
    public Result<TbItemParamCustom> listItemParamsByPage(Page page) {
        Result<TbItemParamCustom> result=null;
        try {
            result = itemParamService.listItemParamsByPage(page);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }

    //保存分组规格参数数据
    @ResponseBody
    @RequestMapping("/item/param/save/{cid}")
    public int saveGroupParams(@PathVariable("cid") Long cid, TbItemParam tbItemParam){
        int i=0;
        try {
            i=itemParamService.addGroupParams(cid,tbItemParam);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }
}
