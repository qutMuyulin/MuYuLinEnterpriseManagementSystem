package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Jobtype;
/**
*
* 工种 dao类
*
**/
public interface JobtypeMapper {
    int delete(Integer id);

    int insert(Jobtype record);

    Jobtype selectJobtypeById(Integer id);

    int update(Jobtype record);

    List<Jobtype> page(PageSearchParam param);
}