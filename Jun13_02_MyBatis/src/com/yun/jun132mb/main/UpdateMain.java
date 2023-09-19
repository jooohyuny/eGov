package com.yun.jun132mb.main;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UpdateMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		SqlSession ss = null;
		try {
			InputStream is = Resources.getResourceAsStream("aaa.xml");
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
			ss = ssf.openSession();
			
			System.out.print("얼마 이상인거 : ");
			BigDecimal p1 = new BigDecimal(k.nextInt());
			System.out.print("얼마 할인 : ");			
			BigDecimal p2 = new BigDecimal(k.nextInt());
			
			CoffeeUpdateValues cuv = new CoffeeUpdateValues(p2, p1);
			
			if (ss.update("coffeeMapper.updateCoffee",cuv) >= 1) {
				System.out.println("수정 성공");
				ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("수정 실패");
		}
		k.close();
		ss.close();
	}
}
