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
import com.ognice.dao.CangkuMapper;
import com.ognice.domain.Cangku;
import com.ognice.service.ICangkuService;
/**
*
* 仓库 service接口实现类
*
**/
@Service("cangkuService")
public class CangkuService implements ICangkuService {
    @Resource
    private CangkuMapper cangkuMapper;

    public Cangku getCangkuById(Integer id) {
        return cangkuMapper.selectCangkuById(id);
    }

    public String save(Cangku record) {
            if (1 == cangkuMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Cangku> cangkus = cangkuMapper.page(param);
        pageResult.setData(cangkus);
        param.setPage(null);
        pageResult.setTotal(cangkuMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Cangku record) {
        return cangkuMapper.update(record);
    }

    public int delete(Integer id) {
        return cangkuMapper.delete(id);
    }

    public List<Cangku> all() {
		// TODO Auto-generated method stub
		return cangkuMapper.page(new PageSearchParam());
	}

}
