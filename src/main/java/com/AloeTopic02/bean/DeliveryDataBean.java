package com.AloeTopic02.bean;

import java.sql.Date;

public class DeliveryDataBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private int dd_id;
	private int users_id;
	private int d_pid;
	private float worktime;
	private Date insertdate;
	private int d_count;
	private int d_discount;
	private float dailyincome;
	
	private MemberBean memberbean;
	private D_platformBean d_platfrombean;
	
	
	public DeliveryDataBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DeliveryDataBean(int users_id, int d_pid, float worktime, Date insertdate, int d_count,
			int d_discount, float dailyincome, MemberBean memberbean, D_platformBean d_platfrombean) {
		super();
		
		this.users_id = users_id;
		this.d_pid = d_pid;
		this.worktime = worktime;
		this.insertdate = insertdate;
		this.d_count = d_count;
		this.d_discount = d_discount;
		this.dailyincome = dailyincome;
		this.memberbean = memberbean;
		this.d_platfrombean = d_platfrombean;
	}


	public void setDd_id(int dd_id) {
		this.dd_id = dd_id;
	}


	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}


	public void setD_pid(int d_pid) {
		this.d_pid = d_pid;
	}


	public int getDd_id() {
		return dd_id;
	}


	public int getUsers_id() {
		return users_id;
	}


	public int getD_pid() {
		return d_pid;
	}


	public float getWorktime() {
		return worktime;
	}


	public void setWorktime(float worktime) {
		this.worktime = worktime;
	}


	public Date getInsertdate() {
		return insertdate;
	}


	public void setInsertdate(Date insertdate) {
		this.insertdate = insertdate;
	}


	public int getD_count() {
		return d_count;
	}


	public void setD_count(int d_count) {
		this.d_count = d_count;
	}


	public int getD_discount() {
		return d_discount;
	}


	public void setD_discount(int d_discount) {
		this.d_discount = d_discount;
	}


	public float getDailyincome() {
		return dailyincome;
	}


	public void setDailyincome(float dailyincome) {
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