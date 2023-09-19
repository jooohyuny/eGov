package com.yun.jun261;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yun.jun261.snack.SnackDAO;

@Controller
public class HomeController {
	
	@Autowired
	private SnackDAO sDAO;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		sDAO.get(req);
		return "index";
	}
	
}
