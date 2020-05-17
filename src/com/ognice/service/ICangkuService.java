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
import com.ognice.domain.Cangku;

/**
*
* 仓库 service接口类
*
**/
public interface ICangkuService {
	//根据id获取
    public Cangku getCangkuById(Integer id);
	//保存入库
    public String save(Cangku record);
    //获取全部数据
    public List<Cangku> all();
	//分页获取
    public PageResult getPages(PageSearchParam param);
	//更新
    public int update(Cangku record);
    //删除
    public int delete(Integer id);

}
