package com.ognice.dao;

import java.util.List;

import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Customer;
/**
*
* 客户 dao类
*
**/
public interface CustomerMapper {
    int delete(Integer id);

    int insert(Customer record);

    Customer selectCustomerById(Integer id);

    int update(Customer record);

    List<Customer> page(PageSearchParam param);
}