package com.sjp.ddshop.dao;

import com.sjp.ddshop.common.dto.Page;
import com.sjp.ddshop.pojo.vo.TbItemCustom;

import java.util.List;

public interface TbItemCustomMapper {

    int countItems();
    List<TbItemCustom> listItemsByPage(Page page);

}
