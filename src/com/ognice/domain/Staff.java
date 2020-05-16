package com.ognice.domain;

import java.util.Date;
/**
*
* 员工 实体类
*
**/
public class Staff {
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

    private Integer jobtypeid;

	public Integer getJobtypeid() {
        return jobtypeid;
    }

    public void setJobtypeid(Integer jobtypeid) {
        this.jobtypeid = jobtypeid;
    }

    private String jobtypename;

	public String getJobtypename() {
        return jobtypename;
    }

    public void setJobtypename(String jobtypename) {
        this.jobtypename = jobtypename;
    }

    private Integer orgid;

	public Integer getOrgid() {
        return orgid;
    }

    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }

    private String orgname;

	public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    private String sex;

	public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String basemoney;

	public String getBasemoney() {
        return basemoney;
    }

    public void setBasemoney(String basemoney) {
        this.basemoney = basemoney;
    }

    private String desc;

	public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private Date intime;

	public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    private String picurl;

	public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

}