package com.sjp.ddshop.service;

import com.sjp.ddshop.pojo.po.TbContent;

import java.util.List;

public interface ContentService {
    List<TbContent> listContentsByCid(Long id);
}
