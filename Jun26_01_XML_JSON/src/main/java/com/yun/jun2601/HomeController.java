package com.yun.jun2601;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yun.jun2601.menu.Menu;
import com.yun.jun2601.menu.MenuDAO;
import com.yun.jun2601.snack.SnackDAO;

@Controller
public class HomeController {
	
	@Autowired
	private SnackDAO sDAO;
	
	@Autowired
	private MenuDAO mDAO;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(Menu m, HttpServletRequest req) {
		sDAO.get(req);
		return "index";
	}
	
}
