package com.yun.gbraucp.member;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import juhyun.yun.db.manager.YunDBManager;

public class MemberDAO {
	private static final MemberDAO MDAO = new MemberDAO();

	private MemberDAO() {
	}

	public static MemberDAO getMdao() {
		return MDAO;
	}

	public void bye(HttpServletRequest req) {
		SqlSession ss = null;
		try {
			ss = YunDBManager.getYdbm().connect();

			Member m = (Member) req.getSession().getAttribute("loginMember");

			if (ss.delete("memberMapper.bye", m) == 1) {
				req.setAttribute("result", "회원탈퇴 성공");
				ss.commit();
				String path = req.getSession().getServletContext().getRealPath("imgg");
				String photo = URLDecoder.decode(m.getYm_photo(), "utf-8");
				new File(path + "/" + photo).delete();
			} else {
				req.setAttribute("result", "회원탈퇴 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "회원탈퇴 실패");
		}
		ss.close();
	}

	public boolean isLogined(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) {
			req.setAttribute("loginPage", "member/logined.jsp");
			return true;
		} else {
			req.setAttribute("loginPage", "member/login.jsp");
			return false;
		}
	}

	public void join(HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("imgg");
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("result", "가입 실패(파일)");
			return;
		}

		SqlSession ss = null;
		try {
			ss = YunDBManager.getYdbm().connect();

			String id = mr.getParameter("id");
			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");

			String y = mr.getParameter("y");
			int mm = Integer.parseInt(mr.getParameter("m"));
			int dd = Integer.parseInt(mr.getParameter("d"));
			String birthday = String.format("%s%02d%02d", y, mm, dd);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date birthday2 = sdf.parse(birthday);

			String addr1 = mr.getParameter("addr1");
			String addr2 = mr.getParameter("addr2");
			String addr3 = mr.getParameter("addr3");
			String addr = addr2 + "!" + addr3 + "!" + addr1;

			String photo = URLEncoder.encode(mr.getFilesystemName("photo"), "utf-8").replace("+", " ");

			Member m = new Member(id, pw, name, birthday2, addr, photo);

			if (ss.insert("memberMapper.join", m) == 1) {
				req.setAttribute("result", "가입성공");
				ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			new File(path + "/" + mr.getFilesystemName("photo")).delete();
			req.setAttribute("result", "가입 실패");
		}
		ss.close();
	}

	public void login(HttpServletRequest req) {
		SqlSession ss = null;
		try {
			ss = YunDBManager.getYdbm().connect();

			req.setCharacterEncoding("utf-8");
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");

			Member inputMember = new Member(id, pw, null, null, null, null);
			Member dbMember = ss.selectOne("memberMapper.login", inputMember);

			if (dbMember != null) {
				if (inputMember.getYm_pw().equals(dbMember.getYm_pw())) {
					req.getSession().setAttribute("loginMember", dbMember);
					req.getSession().setMaxInactiveInterval(15 * 60 * 60);
				} else {
					req.setAttribute("result", "로그인 실패(pw 오류)");
				}
			} else {
				req.setAttribute("result", "로그인 실패(미가입 ID)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "로그인 실패(DB)");
		}
		ss.close();
	}

	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}

	public void splitAddr(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String addr = m.getYm_addr();
		String[] addrArr = addr.split("!");
		req.setAttribute("addr1", addrArr[2]);
		req.setAttribute("addr2", addrArr[0]);
		req.setAttribute("addr3", addrArr[1]);
	}

	public void update(HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("imgg");
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("result", "정보수정실패");
			return;
		}

		SqlSession ss = null;
		String oldFile = null;
		String newFile = null;
		try {
			ss = YunDBManager.getYdbm().connect();

			Member m = (Member) req.getSession().getAttribute("loginMember");
			oldFile = m.getYm_photo();
			newFile = mr.getFilesystemName("photo");
			if (newFile == null) {
				newFile = oldFile;
			} else {
				newFile = URLEncoder.encode(newFile, "utf-8").replace("+", " ");
			}

			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");
			String addr1 = mr.getParameter("addr1");
			String addr2 = mr.getParameter("addr2");
			String addr3 = mr.getParameter("addr3");
			String addr = addr2 + "!" + addr3 + "!" + addr1;

			Member forUpdate = new Member(m.getYm_id(), pw, name, null, addr, newFile);
			
			if (ss.update("memberMapper.update", m) == 1) {
				req.setAttribute("result", "수정성공");
				ss.commit();
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(oldFile, "utf-8");
					new File(path + "/" + oldFile).delete();
				}
				m.setYm_pw(pw);		m.setYm_name(name);
				m.setYm_addr(addr);	m.setYm_photo(newFile);
				req.getSession().setAttribute("loginMember", m);
			} else {
				req.setAttribute("result", "정보수정 실패");
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(newFile, "utf-8");
					new File(path + "/" + newFile).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "정보수정 실패");
			if (!oldFile.equals(newFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "utf-8");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				new File(path + "/" + newFile).delete();
			}
		}
		ss.close();
	}
}
