package com.interview.examples;

public class Student {

	private String name;
	private String city;
	private  int rollnum;
	
	public Student(String name, String city, int rollnum) {
		this.name = name;
		this.city = city;
		this.rollnum = rollnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getRollnum() {
		return rollnum;
	}
	public void setRollnum(int rollnum) {
		this.rollnum = rollnum;
	}
}
