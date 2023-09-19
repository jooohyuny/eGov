package com.yun.jul03.shop;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShoppingController {

	@Autowired
	private ShoppingDAO sDAO;
	
	@RequestMapping(value= "/shopping.get", method=RequestMethod.GET,
			produces = "application/xml; charset=utf-8")
	public @ResponseBody String shoppingGet(
			@RequestParam(value="query") String query, HttpServletRequest req) {
		return sDAO.get(req);
	}
}
