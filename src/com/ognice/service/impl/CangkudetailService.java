/**
 *
 */
package com.ognice.service.impl;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.dao.CangkudetailMapper;
import com.ognice.domain.Cangkudetail;
import com.ognice.service.ICangkudetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
*
* 库存 service接口实现类
*
**/
@Service("cangkudetailService")
public class CangkudetailService implements ICangkudetailService {
    @Resource
    private CangkudetailMapper cangkudetailMapper;

    public Cangkudetail getCangkudetailById(Integer id) {
        return cangkudetailMapper.selectCangkudetailById(id);
    }

    public String save(Cangkudetail record) {
            if (1 == cangkudetailMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Cangkudetail> cangkudetails = cangkudetailMapper.page(param);
        pageResult.setData(cangkudetails);
        param.setPage(null);
        pageResult.setTotal(cangkudetailMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Cangkudetail record) {
        return cangkudetailMapper.update(record);
    }

    public int delete(Integer id) {
        return cangkudetailMapper.delete(id);
    }

    public List<Cangkudetail> all() {
		// TODO Auto-generated method stub
		return cangkudetailMapper.page(new PageSearchParam());
	}

    public Cangkudetail getDetail(Integer cangkuid,Integer materid) {
        // TODO Auto-generated method stub
        return cangkudetailMapper.getCangkuMater(cangkuid,materid);
    }
    public Cangkudetail getProDetail(Integer cangkuid,Integer proid) {
        // TODO Auto-generated method stub
        return cangkudetailMapper.getCangkuPro(cangkuid,proid);
    }

}
