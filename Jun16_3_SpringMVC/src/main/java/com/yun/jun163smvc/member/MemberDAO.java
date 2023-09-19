package com.yun.jun163smvc.member;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class MemberDAO {
	private SimpleDateFormat sdf;
	private SimpleDateFormat sdf2;
	
	public MemberDAO() {
		sdf = new SimpleDateFormat("yyyyMMdd");
		sdf2 = new SimpleDateFormat("yyyyMMdd");
	}
	
	public void join(Member m, HttpServletRequest req) {
		try {
			String bd = req.getParameter("birthday2");
			m.setBirthday(sdf.parse(bd));
			
			String by = sdf2.format(m.getBirthday());
			int birthYear = Integer.parseInt(by);
			
			String cy = sdf2.format(new Date());
			int curYear = Integer.parseInt(cy);
			
			m.setAge(curYear-birthYear +1);
			
			System.out.println(m.getName());
			System.out.println(m.getBirthday());
			System.out.println(m.getAge());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
