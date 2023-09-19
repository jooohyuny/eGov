package com.kwon.gbraucp2.sns;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kwon.gbraucp2.TokenGenerator;
import com.kwon.gbraucp2.member.MemberDAO;
import com.kwon.gbraucp2.weathercolor.WeatherColorDAO;

@Controller
public class SNSController {

	@Autowired
	private MemberDAO mDAO;

	@Autowired
	private SNSDAO sDAO;

	@Autowired
	private TokenGenerator tg;

	@Autowired
	private WeatherColorDAO wcDAO;

	// 지금은 1페이지로 오는데 댓글때는 페이지에 댓글쓰거나 지우면 그 페이지에 남아있는거 구상해보기
	@RequestMapping(value = "/sns.delete", method = RequestMethod.GET)
	public String snsDelete(SNSMsg sm, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.delete(sm, req);
		}
		tg.generate(req);
		// 검색상태는 그대로, 글은 지워졌으니 1페이지로 -> 지금은..
		
		sDAO.get(1, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	@RequestMapping(value = "/sns.reply.delete", method = RequestMethod.GET)
	public String snsReplyDelete(SNSReply sr,
			@RequestParam(value="page") int p, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.deleteReply(sr, req);
		}
		tg.generate(req);
		// 검색상태는 그대로, 글은 지워졌으니 1페이지로 -> 지금은..
		
		sDAO.get(p, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/sns.search", method = RequestMethod.GET)
	public String snsSearch(HttpServletRequest req) {
		mDAO.isLogined(req);
		tg.generate(req);
		sDAO.search(req);
		sDAO.get(1, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/sns.page.change", method = RequestMethod.GET)
	public String snsPageChange(@RequestParam(value = "page") int p, HttpServletRequest req) {
		mDAO.isLogined(req);
		tg.generate(req);
		sDAO.clearSearch(req);
		sDAO.get(p, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/sns.update", method = RequestMethod.GET)
	public String snsUpdate(SNSMsg sm, 
			@RequestParam(value="page") int p, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.update(sm, req);
		}
		tg.generate(req);
		sDAO.get(p, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/sns.write", method = RequestMethod.GET)
	public String snsWrite(SNSMsg sm, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.write(sm, req);
		}
		tg.generate(req);
		sDAO.get(1, req);	// ... 수정을 하면 그 페이지에서 이동하지 않으면 좋겠다..
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	@RequestMapping(value = "/sns.reply.write", method = RequestMethod.GET)
	public String snsReplyWrite(SNSReply sr,
			@RequestParam(value="page") int p,HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.writeReply(sr, req);
		}
		tg.generate(req);
		sDAO.get(p, req);
		// 이거말고 댓글은 작성한 페이지에 남아있을 수 있도록
		// sDAO.clearSearch(req);
		// sDAO.get(1, req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
}
