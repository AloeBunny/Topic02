package com.AloeTopic02.bean;

import java.sql.Date;

public class DeliveryDataBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private String dd_id;
	private String users_id;
	private String d_pid;
	private String insertdate;
	private String worktime;
	private String d_count;
	private String d_discount;
	private String dailyincome;
	
	private MemberBean memberbean;
	private D_platformBean d_platfrombean;
	
	
	public DeliveryDataBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DeliveryDataBean(String dd_id, String users_id, String d_pid, String insertdate, String worktime, String d_count,
			String d_discount, String dailyincome, MemberBean memberbean, D_platformBean d_platfrombean) {
		super();
		this.dd_id = dd_id;
		this.users_id = users_id;
		this.d_pid = d_pid;
		this.insertdate = insertdate;
		this.worktime = worktime;
		this.d_count = d_count;
		this.d_discount = d_discount;
		this.dailyincome = dailyincome;
		this.memberbean = memberbean;
		this.d_platfrombean = d_platfrombean;
	}


	public String getDd_id() {
		return dd_id;
	}


	public void setDd_id(String dd_id) {
		this.dd_id = dd_id;
	}


	public String getUsers_id() {
		return users_id;
	}


	public void setUsers_id(String users_id) {
		this.users_id = users_id;
	}


	public String getD_pid() {
		return d_pid;
	}


	public void setD_pid(String d_pid) {
		this.d_pid = d_pid;
	}


	public String getInsertdate() {
		return insertdate;
	}


	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}


	public String getWorktime() {
		return worktime;
	}


	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}


	public String getD_count() {
		return d_count;
	}


	public void setD_count(String d_count) {
		this.d_count = d_count;
	}


	public String getD_discount() {
		return d_discount;
	}


	public void setD_discount(String d_discount) {
		this.d_discount = d_discount;
	}


	public String getDailyincome() {
		return dailyincome;
	}


	public void setDailyincome(String dailyincome) {
		this.dailyincome = dailyincome;
	}


	public MemberBean getMemberbean() {
		return memberbean;
	}


	public void setMemberbean(MemberBean memberbean) {
		this.memberbean = memberbean;
	}


	public D_platformBean getD_platfrombean() {
		return d_platfrombean;
	}


	public void setD_platfrombean(D_platformBean d_platfrombean) {
		this.d_platfrombean = d_platfrombean;
	}


	

}