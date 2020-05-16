/**
 *
 */
package com.ognice.service.impl;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.dao.AttendMapper;
import com.ognice.domain.Attend;
import com.ognice.service.IAttendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
*
* 考勤 service接口实现类
*
**/
@Service("attendService")
public class AttendService implements IAttendService {
    @Resource
    private AttendMapper attendMapper;

    public Attend getAttendById(Integer id) {
        return attendMapper.selectAttendById(id);
    }

    public String save(Attend record) {
            if (1 == attendMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<Attend> attends = attendMapper.page(param);
        pageResult.setData(attends);
        param.setPage(null);
        pageResult.setTotal(attendMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(Attend record) {
        return attendMapper.update(record);
    }

    public int delete(Integer id) {
        return attendMapper.delete(id);
    }

    public List<Attend> all() {
		// TODO Auto-generated method stub
		return attendMapper.page(new PageSearchParam());
	}

}
