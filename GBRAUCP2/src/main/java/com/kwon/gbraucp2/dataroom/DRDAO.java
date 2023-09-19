package com.kwon.gbraucp2.dataroom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwon.gbraucp2.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class DRDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void delete(DataroomFile df, HttpServletRequest req) {
		try {
			String file = ss.getMapper(DataroomMapper.class).getFile(df);
			if (ss.getMapper(DataroomMapper.class).delete(df)==1) {
				req.setAttribute("result", "삭제성공");
				String path = req.getSession().getServletContext().getRealPath("resources/file");
				file = URLDecoder.decode(file,"utf-8");
				new File(path + "/" + file).delete();
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "삭제실패");
		}
	}
	
	public void get(HttpServletRequest req) {
		DataroomFile df = new DataroomFile(null, null, null, null, "E57373", null);
		req.setAttribute("files1",  ss.getMapper(DataroomMapper.class).get(df));
		
		df.setGd_category("81C784");
		req.setAttribute("files2",  ss.getMapper(DataroomMapper.class).get(df));
		
		df.setGd_category("64B5F6");
		req.setAttribute("files3",  ss.getMapper(DataroomMapper.class).get(df));
		
		df.setGd_category("E0E0E0");
		req.setAttribute("files4",  ss.getMapper(DataroomMapper.class).get(df));
		System.out.println(ss.getMapper(DataroomMapper.class).get(df));
		ss.getMapper(DataroomMapper.class).get(df);
	}
	
	public void download(DataroomFile df, HttpServletRequest req, HttpServletResponse res) {
		// 전부 byte단위로
		// 파일에서 내용  읽어내서(순수 java로 읽어내서)
		FileInputStream fis = null;
		// 클라이언트에게 응답(tomcat)
		ServletOutputStream sos = null;
		try {
			String folder = req.getSession().getServletContext().getRealPath("resources/file");
			
			String file =df.getGd_file();
			
			String fileOriginal = URLDecoder.decode(file,"utf-8");
			fis = new FileInputStream(folder + "/" + fileOriginal);
			
			res.reset(); 	// 응답에 혹시 뭔가 들어가있을까 ->응답객체 비우기
			
			res.setContentType("application/octet-stream");
			res.setHeader("Content-Disposition", "attachment; filename=" +file);
			
			sos = res.getOutputStream();
			
			byte[] b = new byte[4096]; 	//4096byte(4kbyte)씩 처리하려고
											// 왜?? 다른 숫자 넣어도 되는데
											// 남들 다 저렇게 해서
											// (연구결과 저만큼씩 하는게 제일 낫다)
			int data = 0;
			// 0 ~ 4095번까지 읽어서 b에 저장
			// b에 저장한거를 data에 저장
			// data에 저장된게 없지 않을동안 반복
			while ((data = fis.read(b, 0, b.length)) != -1) {
				// b에 저장된거를 응답
				sos.write(b, 0, b.length);
			}
			sos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {sos.close();} catch (Exception e) {}
		try {fis.close();} catch (Exception e) {}
	}
	
	
	public void upload(DataroomFile df, HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/file");
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
			df.setGd_uploader(m.getGm_id());
			df.setGd_title(mr.getParameter("gd_title"));
			df.setGd_category(mr.getParameter("gd_category"));
			String gd_file = URLEncoder.encode(mr.getFilesystemName("gd_file"),"utf-8").replace("+", "");
			df.setGd_file(gd_file);
			
			if (ss.getMapper(DataroomMapper.class).upload(df)==1) {
				req.setAttribute("result", "업로드 성공");
				System.out.println(path);
				System.out.println(path);
				System.out.println(path);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "업로드 실패");
			new File(path +"/"+mr.getFilesystemName("gd_file")).delete();
		}
		
		
	}
	
}
