package com.yun.jun162smvc.cal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {

//	1) 기존 JSP Model 2 스타일
//	@RequestMapping(value="/xy.calculate", method=RequestMethod.GET)
//	public String xyCalculate(HttpServletRequest req, HttpServletResponse res) {
//		int xxx = Integer.parseInt(req.getParameter("xx"));
//		int yyy = Integer.parseInt(req.getParameter("yy"));
//		System.out.println(xxx);
//		System.out.println(yyy);
//		return "output"; 
//	}

//	2) Spring st.
//	@RequestMapping(value = "/xy.calculate", method = RequestMethod.GET)
//	public String xyCalculate(@RequestParam(value = "xx") int xxx, @RequestParam(value = "yy") int yyy) {
//		System.out.println(xxx);
//		System.out.println(yyy);
//		return "output";
//	}

//	3) Spring st.
	@RequestMapping(value = "/xy.calculate", method = RequestMethod.GET)
	public String xyCalculate(XY xy) {
		System.out.println(xy.getXx());
		System.out.println(xy.getYy());
		return "output";
	}

}
