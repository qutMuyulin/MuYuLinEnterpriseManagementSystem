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
import com.ognice.dao.JobtypeMapper;
import com.ognice.domain.Jobtype;
import com.ognice.service.IJobtypeService;
/**
*
* 工种 service接口实现类
*
**/
@Service("jobtypeService")
public class JobtypeService implements IJobtypeService {
    @Resource
    private JobtypeMapper jobtypeMapper;

    public Jobtype getJobtypeById(Integer id) {
        return jobtypeMapper.selectJobtypeById(id);
    }

    public String save(Jobtype record) {
            if (1 == jobtypeMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Jobtype> jobtypes = jobtypeMapper.page(param);
        pageResult.setData(jobtypes);
        param.setPage(null);
        pageResult.setTotal(jobtypeMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Jobtype record) {
        return jobtypeMapper.update(record);
    }

    public int delete(Integer id) {
        return jobtypeMapper.delete(id);
    }

    public List<Jobtype> all() {
		// TODO Auto-generated method stub
		return jobtypeMapper.page(new PageSearchParam());
	}

}
