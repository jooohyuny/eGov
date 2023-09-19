package com.yun.jun132mb.main;

import java.math.BigDecimal;

// 원래는 하나하나해야하고 소스길고...
// library : 시키는대로 하면 자동으로 되는거
// framework : lib + 자체 툴

// MyBatis의 ORM기능 발동조건
// 1) DB필드명과 멤버변수명 같게
// 2) (OracleDB한정) number타입은 BigDecimal로
// 3) 원래하던대로 생성자,  getter/setter
// 4) 날짜는 java.util.Date
public class Coffee {
	private String c_name;
	private BigDecimal c_price;
	
	public Coffee() {
		// TODO Auto-generated constructor stub
	}

	public Coffee(String c_name, BigDecimal c_price) {
		super();
		this.c_name = c_name;
		this.c_price = c_price;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public BigDecimal getC_price() {
		return c_price;
	}

	public void setC_price(BigDecimal c_price) {
		this.c_price = c_price;
	}
	
	
}
