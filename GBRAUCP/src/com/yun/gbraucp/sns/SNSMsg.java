package com.yun.gbraucp.sns;

import java.math.BigDecimal;
import java.util.Date;

public class SNSMsg {
	private BigDecimal ys_no;
	private String ys_writer;
	private String ys_txt;
	private Date ys_date;
	
	private String ym_photo;
	
	public SNSMsg() {
		// TODO Auto-generated constructor stub
	}

	public SNSMsg(BigDecimal ys_no, String ys_writer, String ys_txt, Date ys_date, String ym_photo) {
		super();
		this.ys_no = ys_no;
		this.ys_writer = ys_writer;
		this.ys_txt = ys_txt;
		this.ys_date = ys_date;
		this.ym_photo = ym_photo;
	}

	public BigDecimal getYs_no() {
		return ys_no;
	}

	public void setYs_no(BigDecimal ys_no) {
		this.ys_no = ys_no;
	}

	public String getYs_writer() {
		return ys_writer;
	}

	public void setYs_writer(String ys_writer) {
		this.ys_writer = ys_writer;
	}

	public String getYs_txt() {
		return ys_txt;
	}

	public void setYs_txt(String ys_txt) {
		this.ys_txt = ys_txt;
	}

	public Date getYs_date() {
		return ys_date;
	}

	public void setYs_date(Date ys_date) {
		this.ys_date = ys_date;
	}

	public String getYm_photo() {
		return ym_photo;
	}

	public void setYm_photo(String ym_photo) {
		this.ym_photo = ym_photo;
	}
	
	
	
}
