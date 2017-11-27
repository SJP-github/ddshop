package com.sjp.ddshop.search.web;

import com.sjp.ddshop.pojo.vo.TbSearchItemResult;
import com.sjp.ddshop.service.SearchItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;

@Controller
public class SearchIndexAction {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SearchItemService searchItemService;
    /**
     * 查询系统首页查询，全文检索
     * @param keyword 搜索关键字;跟页面的搜索框name值一致
     * @param page 当前页 默认第一页
     * @param model
     * @return
     */
    
    @RequestMapping("/")
    public String portalIndex(String keyword, @RequestParam(defaultValue = "1") Integer page,
                              Model model){
        if (keyword != null) {
            try {
                keyword=new String(keyword.getBytes("iso-8859-1"),"utf-8");
                //从solr索引库中查询商品列表
                TbSearchItemResult searchResult = searchItemService.search(keyword, page, 60);
                //把结果传递到页面
                model.addAttribute("query", keyword);
                model.addAttribute("totalPages", searchResult.getTotalPages());
                model.addAttribute("page", page);
                model.addAttribute("recourdCount", searchResult.getRecordCount());
                model.addAttribute("itemList", searchResult.getItemList());
            } catch (UnsupportedEncodingException e) {
                logger.error(e.getMessage(),e);
                e.printStackTrace();
            }
           
        }
       
        return "search";
    }
}
