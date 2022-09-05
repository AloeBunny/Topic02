package com.AloeTopic02.bean;

public class DeliveryDataBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private int dd_id;
	private int users_id;
	private int d_pid;
	private float worktime;
	private String insertdate;
	private int d_count;
	private int d_discount;
	private float dailyincome;
	
	private MemberBean memberbean;
	private D_platformBean d_platfrombean;
	
	public int getDd_id() {
		return dd_id;
	}
	public void setDd_id(int dd_id) {
		this.dd_id = dd_id;
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	public int getPlatformid() {
		return d_pid;
	}
	public void setPlatformid(int platformid) {
		this.d_pid = d_pid;
	}
	public float getWorktime() {
		return worktime;
	}
	public void setWorktime(float worktime) {
		this.worktime = worktime;
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
	

	
}