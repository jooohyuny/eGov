package com.yun.jun161sdi.snack;

import java.util.ArrayList;
import java.util.HashMap;

import com.yun.jun161sdi.main.Company;

public class Snack {
	// 기본형급
	private String name;
	private int price;
	
	// 객체급
	private Company maker;
	
	// 컬렉션급
	private String[] material;	// 버터, 땅콩, ...
	private ArrayList<String> characteristics; // 고온에서 10분 구운, 열...
	private HashMap<String, Double> nutrition; // 탄수화물 : 10, 지방: 10
	
	public Snack() {
		// TODO Auto-generated constructor stub
	}

	public Snack(String name, int price, Company maker, String[] material, ArrayList<String> characteristics,
			HashMap<String, Double> nutrition) {
		super();
		this.name = name;
		this.price = price;
		this.maker = maker;
		this.material = material;
		this.characteristics = characteristics;
		this.nutrition = nutrition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Company getMaker() {
		return maker;
	}

	public void setMaker(Company maker) {
		this.maker = maker;
	}

	public String[] getMaterial() {
		return material;
	}

	public void setMaterial(String[] material) {
		this.material = material;
	}

	public ArrayList<String> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(ArrayList<String> characteristics) {
		this.characteristics = characteristics;
	}

	public HashMap<String, Double> getNutrition() {
		return nutrition;
	}

	public void setNutrition(HashMap<String, Double> nutrition) {
		this.nutrition = nutrition;
	}
	
}
