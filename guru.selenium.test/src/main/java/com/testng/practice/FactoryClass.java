package com.testng.practice;

import org.testng.annotations.Factory;

public class FactoryClass {
	
	@Factory
	public Object[] factorySetup() {
		Object[] data = new Object[2];
		data[0] = new TestNGFactory(10);
		data[1] = new TestNGFactory();
		return data;
	}
//This will execute all the methods of TestNGFactory twice once with parametrized constructor
	// and once with the default constructor
}
