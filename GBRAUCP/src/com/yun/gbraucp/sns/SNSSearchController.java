package com.yun.gbraucp.sns;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yun.gbraucp.main.TokenGenerator;
import com.yun.gbraucp.member.MemberDAO;

@WebServlet("/SNSSearchController")
public class SNSSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.getMdao().isLogined(request);
		TokenGenerator.generate(request);
		SNSDAO.getSdao().search(request);
		SNSDAO.getSdao().get(1, request);
		request.setAttribute("contentPage", "sns/sns.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
}


