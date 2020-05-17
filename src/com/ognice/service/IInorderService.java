/**
 *
 */
package com.ognice.service;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Inorder;

import java.util.List;

/**
*
* 采购 service接口类
*
**/
public interface IInorderService {
	//根据id获取
    public Inorder getInorderById(Integer id);
	//保存入库
    public String save(Inorder record);
    //获取全部数据
    public List<Inorder> all();
	//分页获取
    public PageResult getPages(PageSearchParam param);
	//更新
    public int update(Inorder record);
    //删除
    public int delete(Integer id);

}
