/**
 *
 */
package com.ognice.service;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Cangkudetail;

import java.util.List;

/**
*
* 库存 service接口类
*
**/
public interface ICangkudetailService {
	//根据id获取
    public Cangkudetail getCangkudetailById(Integer id);
	//保存入库
    public String save(Cangkudetail record);
    //获取全部数据
    public List<Cangkudetail> all();
	//分页获取
    public PageResult getPages(PageSearchParam param);
	//更新
    public int update(Cangkudetail record);
    //删除
    public int delete(Integer id);

    public Cangkudetail getDetail(Integer cangkuid,Integer materid) ;
    public Cangkudetail getProDetail(Integer cangkuid,Integer proid);

}
