package com.yun.jun2601.menu;

import java.math.BigDecimal;

public class MenuSelector {
	private BigDecimal start;
	private BigDecimal end;
	public MenuSelector() {
		// TODO Auto-generated constructor stub
	}
	public MenuSelector(BigDecimal start, BigDecimal end) {
		super();
		this.start = start;
		this.end = end;
	}
	public BigDecimal getStart() {
		return start;
	}
	public void setStart(BigDecimal start) {
		this.start = start;
	}
	public BigDecimal getEnd() {
		return end;
	}
	public void setEnd(BigDecimal end) {
		this.end = end;
	}
	
	
}
