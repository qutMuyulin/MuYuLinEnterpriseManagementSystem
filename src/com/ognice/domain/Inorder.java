package com.ognice.domain;

import java.util.Date;
/**
*
* 采购 实体类
*
**/
public class Inorder {
    private Integer id;

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer cangkuid;

	public Integer getCangkuid() {
        return cangkuid;
    }

    public void setCangkuid(Integer cangkuid) {
        this.cangkuid = cangkuid;
    }

    private String cangkuname;

	public String getCangkuname() {
        return cangkuname;
    }

    public void setCangkuname(String cangkuname) {
        this.cangkuname = cangkuname;
    }

    private String name;

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer count;

	public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    private Integer materidd;

	public Integer getMateridd() {
        return materidd;
    }

    public void setMateridd(Integer materidd) {
        this.materidd = materidd;
    }

    private Integer proidd;

	public Integer getProidd() {
        return proidd;
    }

    public void setProidd(Integer proidd) {
        this.proidd = proidd;
    }

    private Date created;

	public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    private Integer customerid;

	public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    private String customername;

	public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    private Integer year;

	public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    private Integer month;

	public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    private Double total;

	public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}