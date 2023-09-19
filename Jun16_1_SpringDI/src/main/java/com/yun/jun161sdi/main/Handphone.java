package com.yun.jun161sdi.main;

import org.springframework.beans.factory.annotation.Autowired;

// 세상에 회사라는거는 삼성 뿐 : singleton
// 모든 핸드폰은 삼성에서 : static
public class Handphone {
	// beans2.xml에 등록되어있는
	// 그 하나뿐인 회사랑 자동 연결
	// aac방식이어야만 가능하다
	@Autowired
	private Company maker;
	
	// 생성자 x
	// getter/setter x
	
	public void print() {
		maker.print();
	}
}
