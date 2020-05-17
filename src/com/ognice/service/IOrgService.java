/**
 *
 */
package com.ognice.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Org;

/**
*
* 部门 service接口类
*
**/
public interface IOrgService {
	//根据id获取
    public Org getOrgById(Integer id);
	//保存入库
    public String save(Org record);
    //获取全部数据
    public List<Org> all();
	//分页获取
    public PageResult getPages(PageSearchParam param);
	//更新
    public int update(Org record);
    //删除
    public int delete(Integer id);

}
