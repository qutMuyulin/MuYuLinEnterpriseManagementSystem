package com.ognice.dao;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Inorder;

import java.util.List;

/**
*
* 采购 dao类
*
**/
public interface InorderMapper {
    int delete(Integer id);

    int insert(Inorder record);

    Inorder selectInorderById(Integer id);

    int update(Inorder record);

    List<Inorder> page(PageSearchParam param);
}