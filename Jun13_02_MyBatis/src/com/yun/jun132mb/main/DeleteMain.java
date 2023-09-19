package com.yun.jun132mb.main;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DeleteMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		SqlSession ss = null;
		try {
			InputStream is = Resources.getResourceAsStream("aaa.xml");
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
			ss = ssf.openSession();
			
			System.out.print("이름 : ");			String n = k.next();
			
			Coffee c = new Coffee(n, null);
			
			if (ss.delete("coffeeMapper.delCoffeeByName",c) == 1) {
				System.out.println("삭제 성공");
				ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("삭제 실패");
		}
		k.close();
		ss.close();
	}
}
