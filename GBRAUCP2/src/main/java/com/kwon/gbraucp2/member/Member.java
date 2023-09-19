package com.kwon.gbraucp2.member;

import java.util.Date;

public class Member {
	private String gm_id;
	private String gm_pw;
	private String gm_name;
	private Date gm_birthday;
	private String gm_address;
	private String gm_photo;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String gm_id, String gm_pw, String gm_name, Date gm_birthday, String gm_address, String gm_photo) {
		super();
		this.gm_id = gm_id;
		this.gm_pw = gm_pw;
		this.gm_name = gm_name;
		this.gm_birthday = gm_birthday;
		this.gm_address = gm_address;
		this.gm_photo = gm_photo;
	}

	public String getGm_id() {
		return gm_id;
	}

	public void setGm_id(String gm_id) {
		this.gm_id = gm_id;
	}

	public String getGm_pw() {
		return gm_pw;
	}

	public void setGm_pw(String gm_pw) {
		this.gm_pw = gm_pw;
	}

	public String getGm_name() {
		return gm_name;
	}

	public void setGm_name(String gm_name) {
		this.gm_name = gm_name;
	}

	public Date getGm_birthday() {
		return gm_birthday;
	}

	public void setGm_birthday(Date gm_birthday) {
		this.gm_birthday = gm_birthday;
	}

	public String getGm_address() {
		return gm_address;
	}

	public void setGm_address(String gm_address) {
		this.gm_address = gm_address;
	}

	public String getGm_photo() {
		return gm_photo;
	}

	public void setGm_photo(String gm_photo) {
		this.gm_photo = gm_photo;
	}

}
