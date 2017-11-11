package com.sjp.ddshop.web;

import com.sjp.ddshop.common.dto.TreeNode;
import com.sjp.ddshop.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ItemCatAction {

    @Autowired
    private ItemCatService itemCatService;


    @ResponseBody
    @RequestMapping("/itemCats")
    public List<TreeNode> ListItemCatsByPid(@RequestParam("parentid") Long parentid){
        List<TreeNode> treeNodeList=null;
        try {
            treeNodeList=itemCatService.listItemCatsByPid(parentid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return treeNodeList;
    }
}
