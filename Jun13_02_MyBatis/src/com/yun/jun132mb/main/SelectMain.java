package com.yun.jun132mb.main;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SelectMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		SqlSession ss = null;
		try {
			InputStream is = Resources.getResourceAsStream("aaa.xml");
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
			ss = ssf.openSession();
			
			List<Coffee> coffees = ss.selectList("coffeeMapper.getCoffee");
			
			for (Coffee coffee : coffees) {
				System.out.println(coffee.getC_name());
				System.out.println(coffee.getC_price());
				System.out.println("-------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정 실패");
		}
		k.close();
		ss.close();
	}
}
