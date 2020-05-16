package com.ognice.dao;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Attend;

import java.util.List;

/**
* 考勤 dao类
**/
public interface AttendMapper {
    int delete(Integer id);

    int insert(Attend record);

    Attend selectAttendById(Integer id);

    int update(Attend record);

    List<Attend> page(PageSearchParam param);
}