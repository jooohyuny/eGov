package com.yun.jun132mb.main;


import org.apache.ibatis.session.SqlSession;

import juhyun.yun.db.manager.YunDBManager;

public class ConnectMain2 {
	public static void main(String[] args) {
		SqlSession ss = null;
		try {
			YunDBManager.getYdbm().setSqlSessionFactory("aaa.xml");
			ss = YunDBManager.getYdbm().connect();
			System.out.println("등록 성공");
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
