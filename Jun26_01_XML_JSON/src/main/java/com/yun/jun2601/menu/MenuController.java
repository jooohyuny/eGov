package com.yun.jun2601.menu;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MenuController {

	@Autowired
	private MenuDAO mDAO;
	
	// 테이블 표현하는 객체를 응답
	@RequestMapping(value="/menu.get", method = RequestMethod.GET,
			produces = "application/json; charset=utf-8") 
	public @ResponseBody Menus menuGet(
			 @RequestParam(value="page") int page,
			 HttpServletResponse res) {
		// 외부인에게 XML/JSON응답하게
		res.setHeader("Access-Control-Allow-Origin", "*");
		return mDAO.get2(page);
	}
}
