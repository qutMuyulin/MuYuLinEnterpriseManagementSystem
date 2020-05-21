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
import com.ognice.dao.MaterMapper;
import com.ognice.domain.Mater;
import com.ognice.service.IMaterService;
/**
*
* 原料 service接口实现类
*
**/
@Service("materService")
public class MaterService implements IMaterService {
    @Resource
    private MaterMapper materMapper;

    public Mater getMaterById(Integer id) {
        return materMapper.selectMaterById(id);
    }

    public String save(Mater record) {
            if (1 == materMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Mater> maters = materMapper.page(param);
        pageResult.setData(maters);
        param.setPage(null);
        pageResult.setTotal(materMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Mater record) {
        return materMapper.update(record);
    }

    public int delete(Integer id) {
        return materMapper.delete(id);
    }

    public List<Mater> all() {
		// TODO Auto-generated method stub
		return materMapper.page(new PageSearchParam());
	}

}
