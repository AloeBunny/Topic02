package com.AloeTopic02.bean;

import java.io.Serializable;

public class FullBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String dd_id;
	private String users_id;
	private String d_pid;
	private String insertdate;
	private String worktime;
	private String d_count;
	private String d_discount;
	private String dailyincome;
	private String p_id;
	private String p_name;
	private int m_id;
	private String m_account;
	private String m_password;
	private String nickname;

	public FullBean() {
		// TODO Auto-generated constructor stub
	}

	public FullBean(String dd_id, String users_id, String d_pid, String insertdate, String worktime, String d_count,
			String d_discount, String dailyincome, String p_id, String p_name, int m_id, String m_account,
			String m_password, String nickname) {
		super();
		this.dd_id = dd_id;
		this.users_id = users_id;
		this.d_pid = d_pid;
		this.insertdate = insertdate;
		this.worktime = worktime;
		this.d_count = d_count;
		this.d_discount = d_discount;
		this.dailyincome = dailyincome;
		this.p_id = p_id;
		this.p_name = p_name;
		this.m_id = m_id;
		this.m_account = m_account;
		this.m_password = m_password;
		this.nickname = nickname;
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

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getM_account() {
		return m_account;
	}

	public void setM_account(String m_account) {
		this.m_account = m_account;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
