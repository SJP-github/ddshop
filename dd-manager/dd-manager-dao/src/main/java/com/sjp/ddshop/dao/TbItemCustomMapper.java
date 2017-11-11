package com.sjp.ddshop.dao;

import com.sjp.ddshop.pojo.vo.TbItemCustom;

import java.util.List;
import java.util.Map;

public interface TbItemCustomMapper {

    int countItems(Map<String ,Object> map);
    List<TbItemCustom> listItemsByPage(Map<String ,Object> map);

}
