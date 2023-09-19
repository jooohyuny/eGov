package com.yun.gbraucp.sns;


import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.yun.gbraucp.member.Member;

import juhyun.yun.db.manager.YunDBManager;

public class SNSDAO {
	private int allMsgCount;
	private int msgPerPage;
	
	private static final SNSDAO SDAO = new SNSDAO();
	
	public SNSDAO() {
		msgPerPage = 5;	
	}
	public static SNSDAO getSdao() {
		return SDAO;
	}

	public void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}
	
	public void delete(HttpServletRequest req) {
		SqlSession ss = null;
		try {
			ss = YunDBManager.getYdbm().connect();
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			
			
			if (ss.delete("snsMapper.delete") == 1) {
				req.setAttribute("result", "글 삭제 성공");
				allMsgCount--;
			} else {
				req.setAttribute("result", "글 삭제 실패(?)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "글 삭제 실패(??)");
		}
		ss.close();
	}
	
	public void get(int page, HttpServletRequest req) {
		SqlSession ss = null;
		try {
			ss = YunDBManager.getYdbm().connect();
			
			String search = (String) req.getSession().getAttribute("search");
			int msgCount = allMsgCount;
			if (search == null) {
				search = "";
			} else {
				SNSSelector sSel2 = new SNSSelector(search, null, null);
				msgCount = ss.selectOne("snsMapper.getMsgCount",sSel2);
			}
			int pageCount = (int) Math.ceil(msgCount / (double) msgPerPage);
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("page", page);
			
			int start = (page - 1) * msgPerPage + 1;
			int end = msgPerPage * page;
			SNSSelector sSel = new SNSSelector(search, new BigDecimal(start), new BigDecimal(end));
			
			List<SNSMsg> msgs = ss.selectList("snsMapper.get",sSel);
			req.setAttribute("msgs", msgs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
	
	public void search(HttpServletRequest req) {
		String search = req.getParameter("search");
		req.getSession().setAttribute("search", search);
	}
	
	public void setAllMsgCount() {
		SqlSession ss = null;
		try {
			ss = YunDBManager.getYdbm().connect();
			SNSSelector sSel = new SNSSelector("",null,null);
			allMsgCount = ss.selectOne("snsMapper.getMsgCount",sSel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
	
	public void setAllMsgCount(int msgCount) {
		allMsgCount -= msgCount;
	}
	
	public void write(HttpServletRequest req) {
		SqlSession ss = null;
		try {
			String token = req.getParameter("token");
			String lastToken = (String) req.getSession().getAttribute("lastToken");

			if (lastToken != null && token.equals(lastToken)) {
				req.setAttribute("result", "글쓰기 실패(새로고침)");
				return;
			}

			ss = YunDBManager.getYdbm().connect();

			Member m = (Member) req.getSession().getAttribute("loginMember");
			String writer = m.getYm_id();
			String txt = req.getParameter("txt");
			txt = txt.replace("\r\n", "<br>");

			SNSMsg sm = new SNSMsg(null, writer, txt, null, null);
			
			if(ss.insert("snsMapper.write",sm)==1) {
				req.setAttribute("result", "글쓰기 성공");
				ss.commit();
				req.getSession().setAttribute("lastToken", token);
				allMsgCount++;
			}
		} catch (Exception e) {
			req.setAttribute("result", "글쓰기 실패");
		}
		ss.close();
	}
}
