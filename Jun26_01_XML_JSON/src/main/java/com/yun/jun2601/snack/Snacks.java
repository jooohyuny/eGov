package com.yun.jun2601.snack;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Snacks {// DB테이블을 표현하는 JavaBean
	// 변수명은 단수형 추천
	private List<Snack> snack;
	
	public Snacks() {
		// TODO Auto-generated constructor stub
	}

	public Snacks(List<Snack> snack) {
		super();
		this.snack = snack;
	}

	public List<Snack> getSnack() {
		return snack;
	}
	@XmlElement
	public void setSnack(List<Snack> snack) {
		this.snack = snack;
	}
	
}
