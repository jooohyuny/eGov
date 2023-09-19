package com.kwon.gbraucp2.gallery;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwon.gbraucp2.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class GalleryDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void get(HttpServletRequest req) {
		GalleryFile gf = new GalleryFile(null, null, null, null, "E57373", null);
		req.setAttribute("images", ss.getMapper(GalleryMapper.class).get(gf));
		
	}
	
	public void upload(GalleryFile gf, HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/photo");
		try {
			mr = new MultipartRequest(req, path, 31457280, "utf-8", new DefaultFileRenamePolicy());
			
		} catch (Exception e) {
			req.setAttribute("result", "업로드실패");
			return;
		}
		
		try {
			String token = req.getParameter("token");
			String lastToken = (String) req.getSession().getAttribute("successToken");
			if (lastToken != null && token.equals(lastToken)) {
				req.setAttribute("result", "업로드실패");
				return;
			}
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			gf.setYd_uploader(m.getGm_id());
			gf.setYd_title(mr.getParameter("yd_title"));
			gf.setYd_category(mr.getParameter("yd_category"));
			String yd_file = URLEncoder.encode(mr.getFilesystemName("yd_file"),"utf-8").replace("+", " "
					+ "");
			gf.setYd_file(yd_file);
			
			if (ss.getMapper(GalleryMapper.class).upload(gf)==1) {
				req.setAttribute("result", "갤러리 업로드 성공");
				System.out.println(path);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "갤러리 업로드 실패");
			new File(path + "/"+ mr.getFilesystemName("yd_file")).delete();
		}
		
	}
}














