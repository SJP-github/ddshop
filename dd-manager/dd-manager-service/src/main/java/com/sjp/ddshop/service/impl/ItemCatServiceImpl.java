package com.sjp.ddshop.service.impl;

import com.sjp.ddshop.common.dto.TreeNode;
import com.sjp.ddshop.dao.TbItemCatMapper;
import com.sjp.ddshop.pojo.po.TbItem;
import com.sjp.ddshop.pojo.po.TbItemCat;
import com.sjp.ddshop.pojo.po.TbItemCatExample;
import com.sjp.ddshop.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatDao;

    @Override
    public List<TreeNode> listItemCatsByPid(Long parentid) {
        List<TreeNode> treeNodeList=null;
        try {
            //创建查询模板
            TbItemCatExample example = new TbItemCatExample();
            TbItemCatExample.Criteria criteria = example.createCriteria();
            criteria.andParentIdEqualTo(parentid);
            //执行查询
            List<TbItemCat> itemCatList = itemCatDao.selectByExample(example);
            //要序列化成json的列表对象
            treeNodeList = new ArrayList<TreeNode>();
            for(int i=0;i<itemCatList.size();i++) {
                TbItemCat tbItemCat = itemCatList.get(i);
                TreeNode treeNode=new TreeNode();
                treeNode.setId(tbItemCat.getId());
                treeNode.setText(tbItemCat.getName());
                treeNode.setState(tbItemCat.getIsParent()?"closed":"open");
                treeNodeList.add(treeNode);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return treeNodeList;
    }
}
