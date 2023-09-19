package com.yun.jun161sdi.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// aac로
// beans2.xml에 회사 하나 등록
public class SDIMain2 {
	public static void main(String[] args) {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans2.xml");
		aac.registerShutdownHook();
		
		Handphone h = aac.getBean("h", Handphone.class);
		h.print();
		
		aac.close();
	}
}
