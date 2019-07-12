package com.lzz.domain;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable{
	private Integer eid;
	private String ename;
	private Date hiredate;
	private Double sal;
	private Integer did;
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public Emp(Integer eid, String ename, Date hiredate, Double sal, Integer did) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.hiredate = hiredate;
		this.sal = sal;
		this.did = did;
	}
	public Emp() {
		super();
	}
	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", hiredate=" + hiredate + ", sal=" + sal + ", did=" + did
				+ "]";
	}
	

}
