package com.AloeTopic02.bean;

public class MemberBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private int m_id;
	private String m_account;
	private String m_password;
	private String nickname;
	
	
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