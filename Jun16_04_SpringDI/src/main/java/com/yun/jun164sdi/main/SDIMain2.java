package com.yun.jun164sdi.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yun.jun164sdi.dog.Dog;

// 면접포인트
// GarbageCollection : heap영역 자동정리시스템
//		그 자동 발동 시점 : 그 번지를 가리키는 변수가 없게 되면

// aac : 일단 다 만들어 놓음 -- aac를 처음 불렀을때 객체를 사용하지 않더라도 이미 불러온다. 
public class SDIMain2 {
	public static void main(String[] args) {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans.xml");
		
		// aac가 없어질때 만들어놓은 객체들 없애라고
		aac.registerShutdownHook();
		
		System.out.println("ㅋ");
		
		// Dog dd1 = aac.getBean("d1",Dog.class);
		// dd1.print();
		
		aac.close(); // aac없애기 -> 만들어놨던 객체 없애기
	}
}
