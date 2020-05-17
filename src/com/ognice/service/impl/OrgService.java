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
import com.ognice.dao.OrgMapper;
import com.ognice.domain.Org;
import com.ognice.service.IOrgService;
/**
*
* 部门 service接口实现类
*
**/
@Service("orgService")
public class OrgService implements IOrgService {
    @Resource
    private OrgMapper orgMapper;

    public Org getOrgById(Integer id) {
        return orgMapper.selectOrgById(id);
    }

    public String save(Org record) {
            if (1 == orgMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Org> orgs = orgMapper.page(param);
        pageResult.setData(orgs);
        param.setPage(null);
        pageResult.setTotal(orgMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Org record) {
        return orgMapper.update(record);
    }

    public int delete(Integer id) {
        return orgMapper.delete(id);
    }

    public List<Org> all() {
		// TODO Auto-generated method stub
		return orgMapper.page(new PageSearchParam());
	}

}
