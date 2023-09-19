package com.kwon.gbraucp2.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kwon.gbraucp2.TokenGenerator;
import com.kwon.gbraucp2.sns.SNSDAO;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO mDAO;

	@Autowired
	private SNSDAO sDAO;
	
	@Autowired
	private TokenGenerator tg;
	
	@RequestMapping(value = "/member.bye", method = RequestMethod.GET)
	public String memberBye(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			mDAO.bye(req);
		}
		sDAO.clearSearch(req);
		sDAO.get(1, req);
		tg.generate(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/member.get", method = RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public @ResponseBody Members memberGet(Member m) {
		return mDAO.getMemberIDbyId(m);
	}
	
	@RequestMapping(value = "/member.info.go", method = RequestMethod.GET)
	public String memberInfoGo(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			mDAO.splitAddr(req);
			req.setAttribute("contentPage", "member/info.jsp");
		} else {
			sDAO.clearSearch(req);
			sDAO.get(1, req);
			tg.generate(req);
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/member.info.update", method = RequestMethod.POST)
	public String memberInfoUpdate(Member m, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			mDAO.update(m, req);
			mDAO.splitAddr(req);
			req.setAttribute("contentPage", "member/info.jsp");
		} else {
			sDAO.clearSearch(req);
			sDAO.get(1, req);
			tg.generate(req);
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/member.join", method = RequestMethod.POST)
	public String memberJoin(Member m, HttpServletRequest req) {
		mDAO.join(m, req);
		mDAO.isLogined(req);
		sDAO.clearSearch(req);
		sDAO.get(1, req);
		tg.generate(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/member.join.go", method = RequestMethod.GET)
	public String memberJoinGo(HttpServletRequest req) {
		mDAO.isLogined(req);
		req.setAttribute("contentPage", "member/join.jsp");
		return "index";
	}

	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
	public String memberLogin(Member m, HttpServletRequest req) {
		mDAO.login(m, req);
		mDAO.isLogined(req);
		sDAO.clearSearch(req);
		sDAO.get(1, req);
		tg.generate(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/member.logout", method = RequestMethod.GET)
	public String memberLogout(HttpServletRequest req) {
		mDAO.logout(req);
		mDAO.isLogined(req);
		sDAO.clearSearch(req);
		sDAO.get(1, req);
		tg.generate(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

}
