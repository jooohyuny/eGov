package com.yun.jun2601.menu;

import java.math.BigDecimal;


public class Menu { // 데이터 하나
	private String m_name;
	private BigDecimal m_price;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(String m_name, BigDecimal m_price) {
		super();
		this.m_name = m_name;
		this.m_price = m_price;
	}

	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public BigDecimal getM_price() {
		return m_price;
	}
	public void setM_price(BigDecimal m_price) {
		this.m_price = m_price;
	}
	
	
}
