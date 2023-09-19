package com.yun.jun132mb.main;

import java.math.BigDecimal;

public class CoffeeUpdateValues {
	private BigDecimal setValue;
	private BigDecimal whereValue;
	
	public CoffeeUpdateValues() {
		// TODO Auto-generated constructor stub
	}

	public CoffeeUpdateValues(BigDecimal setValue, BigDecimal whereValue) {
		super();
		this.setValue = setValue;
		this.whereValue = whereValue;
	}

	public BigDecimal getSetValue() {
		return setValue;
	}

	public void setSetValue(BigDecimal setValue) {
		this.setValue = setValue;
	}

	public BigDecimal getWhereValue() {
		return whereValue;
	}

	public void setWhereValue(BigDecimal whereValue) {
		this.whereValue = whereValue;
	}
	
}
