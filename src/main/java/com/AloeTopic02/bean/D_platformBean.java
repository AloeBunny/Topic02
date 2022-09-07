package com.AloeTopic02.bean;

public class D_platformBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private int p_id;
	private String p_name;
	
	
	public D_platformBean(String p_name) {
		super();
		
		this.p_name = p_name;
	}
	public D_platformBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
}