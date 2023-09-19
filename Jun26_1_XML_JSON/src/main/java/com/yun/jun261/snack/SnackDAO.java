package com.yun.jun261.snack;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnackDAO {
	
	@Autowired
	private SqlSession ss;

	public void get(HttpServletRequest req) {
		req.setAttribute("snacks", ss.getMapper(SnackMapper.class).get());
	}
}
