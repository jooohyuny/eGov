package com.yun.jun2601.snack;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SnackController {

	@Autowired
	private SnackDAO sDAO;
	
	// 기존 : index.jsp로 가자
	// 지금 : xml응답
	//	produces= "application/xml; charset=utf-8"은 없어도 되지만 깔끔하게 정리하려면 있는게 좋다
	@RequestMapping(value="/snack.get", method = RequestMethod.GET, 
			produces= "application/xml; charset=utf-8")
	public @ResponseBody Snacks snackGet(HttpServletRequest req) {
		Snacks snacks = sDAO.get2();
		return snacks;
	}
}
