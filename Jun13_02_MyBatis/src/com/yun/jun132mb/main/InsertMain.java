package com.yun.jun132mb.main;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class InsertMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		SqlSession ss = null;
		try {
			InputStream is = Resources.getResourceAsStream("aaa.xml");
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
			ss = ssf.openSession();
			
			System.out.print("이름 : ");			String n = k.next();
			System.out.print("가격 : ");			int p = k.nextInt();
			
			BigDecimal pp = new BigDecimal(p);	// int/double/String -> BigDecimal
//			int ppp = pp.intValue();			// BigDecimal -> int/double/String 
			
			Coffee c = new Coffee(n, pp);
			
			if (ss.insert("coffeeMapper.regCoffee",c) == 1) {
				System.out.println("등록 성공");
				ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("등록 실패");
		}
		k.close();
		ss.close();
	}
}
