/**
 *
 */
package com.ognice.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.dao.CustomerMapper;
import com.ognice.domain.Customer;
import com.ognice.service.ICustomerService;
/**
*
* 客户 service接口实现类
*
**/
@Service("customerService")
public class CustomerService implements ICustomerService {
    @Resource
    private CustomerMapper customerMapper;

    public Customer getCustomerById(Integer id) {
        return customerMapper.selectCustomerById(id);
    }

    public String save(Customer record) {
            if (1 == customerMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Customer> customers = customerMapper.page(param);
        pageResult.setData(customers);
        param.setPage(null);
        pageResult.setTotal(customerMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Customer record) {
        return customerMapper.update(record);
    }

    public int delete(Integer id) {
        return customerMapper.delete(id);
    }

    public List<Customer> all() {
		// TODO Auto-generated method stub
		return customerMapper.page(new PageSearchParam());
	}

}
