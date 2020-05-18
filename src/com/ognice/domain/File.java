package com.ognice.domain;

import java.util.Date;
/**
*
* 文档 实体类
*
**/
public class File {
    private Integer id;

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String fileurl;

	public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

}