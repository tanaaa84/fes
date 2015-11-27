package com.fes.common.mvc.model;

import java.io.Serializable;

public class JsonMes implements Serializable {

	private static final long serialVersionUID = -879340517851984485L;

	private String id;
	private String classid;
	private String status;
	private String dbfile;
	private String dburl;
	private Integer xjzj;
	private Integer nums;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDbfile() {
		return dbfile;
	}

	public void setDbfile(String dbfile) {
		this.dbfile = dbfile;
	}

	public String getDburl() {
		return dburl;
	}

	public void setDburl(String dburl) {
		this.dburl = dburl;
	}

	public Integer getXjzj() {
		return xjzj;
	}

	public void setXjzj(Integer xjzj) {
		this.xjzj = xjzj;
	}

	public Integer getNums() {
		return nums;
	}

	public void setNums(Integer nums) {
		this.nums = nums;
	}

}
