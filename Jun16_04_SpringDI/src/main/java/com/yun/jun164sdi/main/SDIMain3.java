package com.yun.jun164sdi.main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.yun.jun164sdi.dog.Dog;

public class SDIMain3 {
	public static void main(String[] args) {
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdf = new XmlBeanDefinitionReader(dlbf);
		xbdf.loadBeanDefinitions(new ClassPathResource("beans.xml"));
		
		// 기본생성자
		Dog dd1 = dlbf.getBean("d1",Dog.class);
		dd1.print();
		System.out.println("----------");
		// setter
		Dog dd2	= dlbf.getBean("d2",Dog.class);
		dd2.print();
		System.out.println("----------");
		// 오버로딩된 생성자
		Dog dd3	= dlbf.getBean("d3",Dog.class);
		dd3.print();
	}
}
