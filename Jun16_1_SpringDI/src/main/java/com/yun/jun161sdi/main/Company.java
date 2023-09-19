package com.yun.jun161sdi.main;

public class Company {
	private String name;
	private String address;
	private int employeeCount;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(String name, String address, int employeeCount) {
		super();
		this.name = name;
		this.address = address;
		this.employeeCount = employeeCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	
	
	public void print() {
		System.out.println(name);
		System.out.println(address);
		System.out.println(employeeCount);
	}
}
