package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.File;
/**
*
* 文档 dao类
*
**/
public interface FileMapper {
    int delete(Integer id);

    int insert(File record);

    File selectFileById(Integer id);

    int update(File record);

    List<File> page(PageSearchParam param);
}