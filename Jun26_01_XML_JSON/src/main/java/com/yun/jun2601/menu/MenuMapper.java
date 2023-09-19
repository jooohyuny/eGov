package com.yun.jun2601.menu;

import java.util.List;

public interface MenuMapper {
	public abstract List<Menu> get(MenuSelector ms);
	public abstract int getAllMenuCount();
	
}
