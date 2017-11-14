package com.sjp.ddshop.service.impl;

import com.sjp.ddshop.common.dto.Page;
import com.sjp.ddshop.common.dto.Result;
import com.sjp.ddshop.dao.TbItemParamCustomMapper;
import com.sjp.ddshop.pojo.vo.TbItemParamCustom;
import com.sjp.ddshop.service.ItemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemParamServiceImpl implements ItemParamService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TbItemParamCustomMapper itemParamCustomDao;

    @Override
    public Result<TbItemParamCustom> listItemParamsByPage(Page page) {
        Result<TbItemParamCustom> result=null;
        try {
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("page", page);
            //取出tb_item_param这张表的记录总数
            int count = itemParamCustomDao.countItemParams();
            //查找每页的数据集合
            List<TbItemParamCustom> list = itemParamCustomDao.listItemParamsByPage(map);
            result = new Result<TbItemParamCustom>();
            result.setTotal(count);
            result.setRows(list);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }
}
