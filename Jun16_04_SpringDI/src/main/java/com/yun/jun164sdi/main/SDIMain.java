package com.yun.jun164sdi.main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.yun.jun164sdi.dog.Dog;


// 1. beans.xml은 설계도, 그 설계도대로 java쪽에서 실제 객체 만드는거	 - 오답
// 2. beans.xml에 객체 만들어 놓은거고, java쪽에서는 불러오기만 하는거 - 이게 정답
// dlbf : 처음 부를때 객체를 만든다 -- dlbf.getBean("d1",Dog.class); 하는 부분에서 처음으로 시행되는거
public class SDIMain {
	public static void main(String[] args) {
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdf = new XmlBeanDefinitionReader(dlbf);
		xbdf.loadBeanDefinitions(new ClassPathResource("beans.xml"));
		System.out.println("ㅋ");
		
		Dog dd1 = dlbf.getBean("d1", Dog.class);
		dd1.print();
		
		
	}
}
