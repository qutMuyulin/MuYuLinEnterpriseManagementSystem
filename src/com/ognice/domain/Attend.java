package com.ognice.domain;

import java.util.Date;
/**
*
* 考勤 实体类
*
**/
public class Attend {
    private Integer id;

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Date starttime;

	public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    private Date endtime;

	public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    private Double count;

	public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    private Date created;

	public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    private Integer staffid;

	public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    private String staffname;

	public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    private Integer year;

	public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    private Integer type;

	public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    private Integer month;

	public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

}