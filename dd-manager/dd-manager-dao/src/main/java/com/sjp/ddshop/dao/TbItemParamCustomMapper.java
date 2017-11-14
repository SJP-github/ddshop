package com.sjp.ddshop.dao;

import com.sjp.ddshop.pojo.vo.TbItemParamCustom;

import java.util.List;
import java.util.Map;

public interface TbItemParamCustomMapper {
    //查询规格参数的总数量
    int countItemParams();
    //每一页的数据
    List<TbItemParamCustom> listItemParamsByPage(Map<String, Object> map);
}
