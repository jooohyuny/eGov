package com.kwon.gbraucp2.gallery;

import java.math.BigDecimal;
import java.util.Date;

public class GalleryFile {
	private BigDecimal yd_no;
	private String yd_uploader;
	private String yd_title;
	private String yd_file;
	private String yd_category;
	private Date yd_date;
	
	public GalleryFile() {
		// TODO Auto-generated constructor stub
	}

	public GalleryFile(BigDecimal yd_no, String yd_uploader, String yd_title, String yd_file, String yd_category,
			Date yd_date) {
		super();
		this.yd_no = yd_no;
		this.yd_uploader = yd_uploader;
		this.yd_title = yd_title;
		this.yd_file = yd_file;
		this.yd_category = yd_category;
		this.yd_date = yd_date;
	}

	public BigDecimal getYd_no() {
		return yd_no;
	}

	public void setYd_no(BigDecimal yd_no) {
		this.yd_no = yd_no;
	}

	public String getYd_uploader() {
		return yd_uploader;
	}

	public void setYd_uploader(String yd_uploader) {
		this.yd_uploader = yd_uploader;
	}

	public String getYd_title() {
		return yd_title;
	}

	public void setYd_title(String yd_title) {
		this.yd_title = yd_title;
	}

	public String getYd_file() {
		return yd_file;
	}

	public void setYd_file(String yd_file) {
		this.yd_file = yd_file;
	}

	public String getYd_category() {
		return yd_category;
	}

	public void setYd_category(String yd_category) {
		this.yd_category = yd_category;
	}

	public Date getYd_date() {
		return yd_date;
	}

	public void setYd_date(Date yd_date) {
		this.yd_date = yd_date;
	}
	
	
}
