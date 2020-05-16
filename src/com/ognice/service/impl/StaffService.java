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
import com.ognice.dao.StaffMapper;
import com.ognice.domain.Staff;
import com.ognice.service.IStaffService;
/**
*
* 员工 service接口实现类
*
**/
@Service("staffService")
public class StaffService implements IStaffService {
    @Resource
    private StaffMapper staffMapper;

    public Staff getStaffById(Integer id) {
        return staffMapper.selectStaffById(id);
    }

    public String save(Staff record) {
            if (1 == staffMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Staff> staffs = staffMapper.page(param);
        pageResult.setData(staffs);
        param.setPage(null);
        pageResult.setTotal(staffMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Staff record) {
        return staffMapper.update(record);
    }

    public int delete(Integer id) {
        return staffMapper.delete(id);
    }

    public List<Staff> all() {
		// TODO Auto-generated method stub
		return staffMapper.page(new PageSearchParam());
	}

}
