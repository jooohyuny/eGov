package com.kwon.gbraucp2.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwon.gbraucp2.sns.SNSDAO;
import com.kwon.gbraucp2.sns.SNSMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {
	@Autowired
	private SNSDAO sDAO;
	
	@Autowired
	private SqlSession ss;
	private SimpleDateFormat sdf;

	public MemberDAO() {
		sdf = new SimpleDateFormat("yyyyMMdd");
	}

	public void bye(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			// 그 사람이 쓴 글 수 세어놓고
			int msgCount = ss.getMapper(SNSMapper.class).getMsgCountByWriter(m);
			
			if (ss.getMapper(MemberMapper.class).bye(m) == 1) {
				req.setAttribute("result", "탈퇴성공");
				
				// 그만큼 갯수처리
				sDAO.setAllMsgCount(msgCount);
				
				String path = req.getSession().getServletContext().getRealPath("resources/img");
				String file = URLDecoder.decode(m.getGm_photo(), "utf-8");
				new File(path + "/" + file).delete();

				logout(req);
				isLogined(req);

				// ...
			} else {
				req.setAttribute("result", "탈퇴실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "탈퇴실패");
		}
	}

	public boolean isLogined(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) {
			req.setAttribute("loginPage", "menu.jsp");
			return true;
		} else {
			req.setAttribute("loginPage", "member/login.jsp");
			return false;
		}
	}

	public Members getMemberIDbyId(Member m) {
		return new Members(ss.getMapper(MemberMapper.class).getMemberIDByID(m));
	}
	
	
	public void join(Member m, HttpServletRequest req) {
		// 원래
		// 1) String 변수명 = req.getParameter("파라메터명");
		// 2) 형변환
		// 3) JavaBean객체로
		// SpringMVC가 1, 2, 3을 자동으로 해주는데
		// 파일업로드때는 mr.getParameter("파라메터명")으로 시작이니...
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		try {
			mr = new MultipartRequest(req, path, 31457280, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("result", "가입실패(프사)");
			return;
		}

		try {
			m.setGm_id(mr.getParameter("gm_id"));
			m.setGm_pw(mr.getParameter("gm_pw"));
			m.setGm_name(mr.getParameter("gm_name"));

			String jumin1 = mr.getParameter("gm_jumin1");
			int jumin2 = Integer.parseInt(mr.getParameter("gm_jumin2"));
			if (jumin2 < 3) {
				jumin1 = "19" + jumin1;
			} else {
				jumin1 = "20" + jumin1;
			}
			m.setGm_birthday(sdf.parse(jumin1));

			String addr1 = mr.getParameter("gm_address1");
			String addr2 = mr.getParameter("gm_address2");
			String addr3 = mr.getParameter("gm_address3");
			m.setGm_address(addr2 + "!" + addr3 + "!" + addr1);

			String photo = mr.getFilesystemName("gm_photo");
			photo = URLEncoder.encode(photo, "utf-8");
			photo = photo.replace("+", " ");
			m.setGm_photo(photo);

			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				req.setAttribute("result", "가입성공");
			}
		} catch (Exception e) {
			req.setAttribute("result", "가입실패");
			new File(path + "/" + mr.getFilesystemName("gm_photo")).delete();
		}
	}

	public void login(Member inputMember, HttpServletRequest req) {
		try {
			Member dbMember = ss.getMapper(MemberMapper.class).getMemberByID(inputMember);
			if (dbMember != null) {
				if (inputMember.getGm_pw().equals(dbMember.getGm_pw())) {
					req.getSession().setAttribute("loginMember", dbMember);
					req.getSession().setMaxInactiveInterval(30*60);
				} else {
					req.setAttribute("result", "로그인실패(PW)");
				}
			} else {
				req.setAttribute("result", "로그인실패(없는계정)");
			}
		} catch (Exception e) {
			req.setAttribute("result", "로그인실패(DB)");
		}
	}

	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}

	public void splitAddr(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String addr = m.getGm_address();
		String[] addr2 = addr.split("!");
		req.setAttribute("addr1", addr2[2]);
		req.setAttribute("addr2", addr2[0]);
		req.setAttribute("addr3", addr2[1]);
	}

	public void update(Member newMember, HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		try {
			mr = new MultipartRequest(req, path, 31457280, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("result", "수정실패(프사)");
			return;
		}

		Member oldMember = (Member) req.getSession().getAttribute("loginMember");
		String oldFile = oldMember.getGm_photo();
		String newFile = null;
		try {
			newMember.setGm_id(oldMember.getGm_id());
			newMember.setGm_pw(mr.getParameter("gm_pw"));
			newMember.setGm_name(mr.getParameter("gm_name"));

			String addr1 = mr.getParameter("gm_address1");
			String addr2 = mr.getParameter("gm_address2");
			String addr3 = mr.getParameter("gm_address3");
			newMember.setGm_address(addr2 + "!" + addr3 + "!" + addr1);

			newFile = mr.getFilesystemName("gm_photo");
			if (newFile == null) {
				newFile = oldFile;
			} else {
				newFile = URLEncoder.encode(newFile, "utf-8").replace("+", " ");
			}
			newMember.setGm_photo(newFile);

			if (ss.getMapper(MemberMapper.class).update(newMember) == 1) {
				req.setAttribute("result", "수정성공");
				if (!newFile.equals(oldFile)) {
					oldFile = URLDecoder.decode(oldFile, "utf-8");
					new File(path + "/" + oldFile).delete();
				}
				// newMember = ss.getMapper(MemberMapper.class).getMemberByID(newMember);
				newMember.setGm_birthday(oldMember.getGm_birthday());
				req.getSession().setAttribute("loginMember", newMember);
			} else {
				req.setAttribute("result", "수정실패");
				if (!newFile.equals(oldFile)) {
					newFile = URLDecoder.decode(newFile, "utf-8");
					new File(path + "/" + newFile).delete();
				}
			}
		} catch (Exception e) {
			req.setAttribute("result", "수정실패(DB)");
			if (!newFile.equals(oldFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "utf-8");
					new File(path + "/" + newFile).delete();
				} catch (UnsupportedEncodingException e1) {
				}
			}
		}

	}
}
