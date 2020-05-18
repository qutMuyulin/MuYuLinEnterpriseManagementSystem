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
import com.ognice.domain.File;

/**
*
* 文档 service接口类
*
**/
public interface IFileService {
	//根据id获取
    public File getFileById(Integer id);
	//保存入库
    public String save(File record);
    //获取全部数据
    public List<File> all();
	//分页获取
    public PageResult getPages(PageSearchParam param);
	//更新
    public int update(File record);
    //删除
    public int delete(Integer id);

}
