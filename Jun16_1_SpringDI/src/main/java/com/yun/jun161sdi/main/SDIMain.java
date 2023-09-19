package com.yun.jun161sdi.main;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yun.jun161sdi.snack.Snack;

public class SDIMain {
	public static void main(String[] args) {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans.xml");
		aac.registerShutdownHook();
//		Company c = aac.getBean("c", Company.class);
//		c.print();
		
		Snack s = aac.getBean("s1",Snack.class);
		System.out.println(s.getName());
		System.out.println(s.getPrice());
		System.out.println(s.getMaker().getName());
		System.out.println(s.getMaker().getAddress());
		System.out.println(s.getMaker().getEmployeeCount());
		
		for (String str : s.getMaterial()) {
			System.out.println(str);
		}
		for (String string : s.getCharacteristics()) {
			System.out.println(string);
		}
		System.out.println(s.getNutrition().get("탄수화물"));
		System.out.println(s.getNutrition().get("지방"));
		aac.close();
	}
}
