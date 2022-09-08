package com.selenium.practise1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GreenCartTest {
	
	@Test(priority=-3)
	public void test1() {
		System.out.println("test1");
		Assert.assertEquals(1, 1);
	}

	@Test(priority=-1)
	public void test2() {
		System.out.println("test2");
		Assert.assertEquals(1, 1);
	}
	
	
	@Test(priority=-10)
	public void test3() {
		System.out.println("test3");
		Assert.assertEquals(1, 1);
	}

}
