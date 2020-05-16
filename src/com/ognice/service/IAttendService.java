/**
 *
 */
package com.ognice.service;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Attend;

import java.util.List;

/**
*
* 考勤 service接口类
*
**/
public interface IAttendService {
	//根据id获取
    public Attend getAttendById(Integer id);
	//保存入库
    public String save(Attend record);
    //获取全部数据
    public List<Attend> all();
	//分页获取
    public PageResult getPages(PageSearchParam param);
	//更新
    public int update(Attend record);
    //删除
    public int delete(Integer id);

}
