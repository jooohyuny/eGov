package com.yun.gbraucp.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yun.gbraucp.member.MemberDAO;
import com.yun.gbraucp.sns.SNSDAO;

import juhyun.yun.db.manager.YunDBManager;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeController() {
		YunDBManager.getYdbm().setSqlSessionFactory("com/yun/gbraucp/main/config.xml");
		SNSDAO.getSdao().setAllMsgCount();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		DateManager.getCurYear(request);
//		TokenGenerator.generate(request);
//		request.setAttribute("loginPage", "member/login.jsp");
		MemberDAO.getMdao().isLogined(request);
		request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
