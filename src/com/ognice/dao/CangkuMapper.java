package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Cangku;
/**
*
* 仓库 dao类
*
**/
public interface CangkuMapper {
    int delete(Integer id);

    int insert(Cangku record);

    Cangku selectCangkuById(Integer id);

    int update(Cangku record);

    List<Cangku> page(PageSearchParam param);
}