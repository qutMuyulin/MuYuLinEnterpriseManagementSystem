/**
 *
 */
package com.ognice.service.impl;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.dao.InorderMapper;
import com.ognice.domain.Inorder;
import com.ognice.service.IInorderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
*
* 采购 service接口实现类
*
**/
@Service("inorderService")
public class InorderService implements IInorderService {
    @Resource
    private InorderMapper inorderMapper;

    public Inorder getInorderById(Integer id) {
        return inorderMapper.selectInorderById(id);
    }

    public String save(Inorder record) {
            if (1 == inorderMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Inorder> inorders = inorderMapper.page(param);
        pageResult.setData(inorders);
        param.setPage(null);
        pageResult.setTotal(inorderMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Inorder record) {
        return inorderMapper.update(record);
    }

    public int delete(Integer id) {
        return inorderMapper.delete(id);
    }

    public List<Inorder> all() {
		// TODO Auto-generated method stub
		return inorderMapper.page(new PageSearchParam());
	}

}
