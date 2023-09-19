package com.yun.jun2601.menu;

import java.util.List;


public class Menus { // 데이터들 (테이블)
	private List<Menu> menu;
	
	public Menus() {
		// TODO Auto-generated constructor stub
	}

	public Menus(List<Menu> menu) {
		super();
		this.menu = menu;
	}

	public List<Menu> getMenu() {
		return menu;
	}
	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	
	
}
