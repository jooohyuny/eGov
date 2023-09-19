package com.kwon.gbraucp2.gallery;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwon.gbraucp2.TokenGenerator;
import com.kwon.gbraucp2.dataroom.DataroomFile;
import com.kwon.gbraucp2.member.MemberDAO;
import com.kwon.gbraucp2.sns.SNSDAO;

@Controller
public class GalleryController {
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private SNSDAO sDAO;
	
	@Autowired
	private GalleryDAO gDAO;
	
	@Autowired
	private TokenGenerator tg;
	
	@RequestMapping(value = "/gallery.go", method= RequestMethod.GET)
	public String galleryGo(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			gDAO.get(req);
			req.setAttribute("contentPage", "gallery.jsp");
		} else {
			sDAO.get(1, req);
			req.setAttribute("contentPage", "home.jsp");
		}
		tg.generate(req);
		return "index";
	}
	@RequestMapping(value = "/gallery.upload", method= RequestMethod.POST)
	public String dataroomUpload(GalleryFile gf, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			gDAO.upload(gf, req);
			gDAO.get(req);
			req.setAttribute("contentPage", "gallery.jsp");
		} else {
			sDAO.get(1, req);
			req.setAttribute("contentPage", "home.jsp");
		}
		tg.generate(req);
		return "index";
	}
	
	
}
