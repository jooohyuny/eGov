package com.yun.gbraucp.member;

import java.util.Date;

public class Member {
	private String ym_id;
	private String ym_pw;
	private String ym_name;
	private Date ym_birthday;
	private String ym_addr;
	private String ym_photo;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String ym_id, String ym_pw, String ym_name, Date ym_birthday, String ym_addr, String ym_photo) {
		super();
		this.ym_id = ym_id;
		this.ym_pw = ym_pw;
		this.ym_name = ym_name;
		this.ym_birthday = ym_birthday;
		this.ym_addr = ym_addr;
		this.ym_photo = ym_photo;
	}

	public String getYm_id() {
		return ym_id;
	}

	public void setYm_id(String ym_id) {
		this.ym_id = ym_id;
	}

	public String getYm_pw() {
		return ym_pw;
	}

	public void setYm_pw(String ym_pw) {
		this.ym_pw = ym_pw;
	}

	public String getYm_name() {
		return ym_name;
	}

	public void setYm_name(String ym_name) {
		this.ym_name = ym_name;
	}

	public Date getYm_birthday() {
		return ym_birthday;
	}

	public void setYm_birthday(Date ym_birthday) {
		this.ym_birthday = ym_birthday;
	}

	public String getYm_addr() {
		return ym_addr;
	}

	public void setYm_addr(String ym_addr) {
		this.ym_addr = ym_addr;
	}

	public String getYm_photo() {
		return ym_photo;
	}

	public void setYm_photo(String ym_photo) {
		this.ym_photo = ym_photo;
	}

	
	
	
}
