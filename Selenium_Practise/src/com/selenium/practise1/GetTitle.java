package com.selenium.practise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class GetTitle {
	public static WebDriver driver;

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver","/Users/gmitikela/GitRepo/Learnings/Selenium/chromedriver/chromedriver");
		System.setProperty("webdriver.gecko.driver","/Users/gmitikela/GitRepo/Selenium_challenge/browser_drivers/geckodriver");
		//Launching the browser with website url	
			 //driver=new ChromeDriver();  
			 driver=new FirefoxDriver();  
			driver.get("https://www.saucedemo.com/");
			WebElement obj= driver.findElement(By.xpath("//input[@id='login-button']"));
			String s = obj.getCssValue("background-color");
			System.out.println(s);
			String Hexbackcolor = Color.fromString(s).asHex();
			System.out.println(Hexbackcolor);
			

	}

}
