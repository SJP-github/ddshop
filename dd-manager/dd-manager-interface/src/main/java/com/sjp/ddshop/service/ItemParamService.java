package com.sjp.ddshop.service;

import com.sjp.ddshop.common.dto.Page;
import com.sjp.ddshop.common.dto.Result;
import com.sjp.ddshop.pojo.vo.TbItemParamCustom;

public interface ItemParamService {
    Result<TbItemParamCustom> listItemParamsByPage(Page page);
}
