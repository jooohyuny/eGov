package com.yun.jun2601.menu;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MenuDAO {
	
	@Autowired
	private SqlSession ss;
	
	
	public void get(MenuSelector ms, HttpServletRequest req) {
		req.setAttribute("menus", ss.getMapper(MenuMapper.class).get(ms));
	}
	// 테이블 표현하는 객체로 만들어 리턴
	public Menus get2(int page) {
		int menuCount = ss.getMapper(MenuMapper.class).getAllMenuCount();
		int menuPerPage = 5;
		int pageCount = (int) Math.ceil(menuCount/(double)menuPerPage);
		if (page>pageCount) {
			return null;
		}
		
		int start = (page -1) * menuPerPage +1;
		int end = page * menuPerPage;
		MenuSelector ms = new MenuSelector(new BigDecimal(start), new BigDecimal(end));
		return new Menus(ss.getMapper(MenuMapper.class).get(ms));
	}
	
		
}
