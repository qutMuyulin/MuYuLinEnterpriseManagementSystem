package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Mater;
/**
*
* 原料 dao类
*
**/
public interface MaterMapper {
    int delete(Integer id);

    int insert(Mater record);

    Mater selectMaterById(Integer id);

    int update(Mater record);

    List<Mater> page(PageSearchParam param);
}