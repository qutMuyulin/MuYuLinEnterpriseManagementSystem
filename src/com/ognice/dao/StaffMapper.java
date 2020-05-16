package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Staff;
/**
*
* 员工 dao类
*
**/
public interface StaffMapper {
    int delete(Integer id);

    int insert(Staff record);

    Staff selectStaffById(Integer id);

    int update(Staff record);

    List<Staff> page(PageSearchParam param);
}