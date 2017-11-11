package com.sjp.ddshop.service;

import com.sjp.ddshop.common.dto.TreeNode;

import java.util.List;

public interface ItemCatService {
    List<TreeNode> listItemCatsByPid(Long parentid);
}
