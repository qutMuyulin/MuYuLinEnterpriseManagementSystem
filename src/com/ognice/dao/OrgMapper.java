package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Org;
/**
*
* 部门 dao类
*
**/
public interface OrgMapper {
    int delete(Integer id);

    int insert(Org record);

    Org selectOrgById(Integer id);

    int update(Org record);

    List<Org> page(PageSearchParam param);
}