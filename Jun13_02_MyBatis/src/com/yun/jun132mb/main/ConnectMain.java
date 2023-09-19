package com.yun.jun132mb.main;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


// MyBatis :
//		Java + DB 유지보수 용이
//		DB ORM(Object Relationship Mapping) Framework

//					DB연결정보			SQL
// JDBC				.java			.java
// ConnectionPool	context.xml		.java
// MyBatis			???.xml			???.xml

public class ConnectMain {
	public static void main(String[] args) {
		// Connection con = null; 과 같이 연결해주는 것 ↓
		SqlSession ss = null;
		try {
			// aaa.xml은 설계도 같은 느낌
			InputStream is = Resources.getResourceAsStream("aaa.xml");
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
			ss = ssf.openSession();

			//  sql의 namespace.id를 입력하면된다.
			int row = ss.insert("coffeeMapper.regCoffee");
			if (row == 1) {
				System.out.println("등록 성공");
				ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("등록 실패");
		}
		ss.close();
	}
}















