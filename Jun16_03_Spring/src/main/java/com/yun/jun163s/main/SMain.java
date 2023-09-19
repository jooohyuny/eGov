package com.yun.jun163s.main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

// 면접 예상질문
// Spring : POJO를 사용, IoC형태로 DI해주는 Framework
//		POJO(Plain Old Java Object)를 사용
//		IoC(Inversion of Control)
//			제어의 역전
//			프로그램 -제어-> 파일 
//			v 파일 -제어-> 프로그램 
//		DI(Dependency Injection)
//			의존성 주입
//			객체만들고 값 넣고
//	객체를 외부파일에 만들고 그것을 제어하는것(가져다가 사용하는것)

public class SMain {
	public static void main(String[] args) {
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdf = new XmlBeanDefinitionReader(dlbf);
		
		xbdf.loadBeanDefinitions(new ClassPathResource("hero.xml"));
		
		//Avengers aa = (Avengers) dlbf.getBean("a");
		Avengers aa = dlbf.getBean("a",Avengers.class);
		aa.attack();
		
	}
}
