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
import com.ognice.dao.FileMapper;
import com.ognice.domain.File;
import com.ognice.service.IFileService;
/**
*
* 文档 service接口实现类
*
**/
@Service("fileService")
public class FileService implements IFileService {
    @Resource
    private FileMapper fileMapper;

    public File getFileById(Integer id) {
        return fileMapper.selectFileById(id);
    }

    public String save(File record) {
            if (1 == fileMapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<File> files = fileMapper.page(param);
        pageResult.setData(files);
        param.setPage(null);
        pageResult.setTotal(fileMapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(File record) {
        return fileMapper.update(record);
    }

    public int delete(Integer id) {
        return fileMapper.delete(id);
    }

    public List<File> all() {
		// TODO Auto-generated method stub
		return fileMapper.page(new PageSearchParam());
	}

}
