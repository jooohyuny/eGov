package com.yun.gbraucp.sns;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yun.gbraucp.main.TokenGenerator;
import com.yun.gbraucp.member.MemberDAO;

@WebServlet("/SNSDeleteController")
public class SNSDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.getMdao().isLogined(request)) {
			SNSDAO.getSdao().delete(request);
		}
		TokenGenerator.generate(request);
		SNSDAO.getSdao().clearSearch(request);
		SNSDAO.getSdao().get(1, request);
		request.setAttribute("contentPage", "sns/sns.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}
}




