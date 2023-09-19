package com.yun.jun164sdi.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yun.jun164sdi.human.Human;

//	human의 name과 age는 value로 값을 주고, human의 속해있는 pet의 Dog은 ref(참조)로 값을 준다
//	수정할 만한 값을 Spring에서 유지보수한다. xml에 변경가능성이 있는 것을 작성한다.
//	내가 만든 객체(Dog,Human 등등)뿐만아니라 java에 내장되어있는 것(SimpleDateFormat 등등)도 가능하다 
public class SDIMain4 {
	public static void main(String[] args) {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans.xml");
		aac.registerShutdownHook();
		System.out.println("------------");
		
		Human hh1 = aac.getBean("h1",Human.class);
		hh1.print();
		System.out.println("------------");
		
		Human hh2 = aac.getBean("h2",Human.class);
		hh2.print();
		System.out.println("------------");
		
		// 현재시간 표현하는 거 꼭 기억하기
		Date now = new Date(); // 현재시간날짜 
		// 날짜형식 (2023/06/15 -> 6월 15일
		SimpleDateFormat sdf = aac.getBean("sdf",SimpleDateFormat.class);
		String result = sdf.format(now);
		System.out.println(result);
		
		aac.close();
	}
}
