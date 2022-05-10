package com.selenium.practise1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestNgTest {

	public static void main(String[] args) throws InterruptedException {
		String Expected_Price="";
		
		
	//Setting the driver path
		System.setProperty("webdriver.chrome.driver","/Users/gmitikela/GitRepo/Selenium_challenge/browser_drivers/chromedriver/chromedriver");
		
	//Launching the browser with website url	
		WebDriver driver=new ChromeDriver();  
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(10000);
		
		WebElement veggie = driver.findElement(By.xpath("//div[@class='product']/h4[contains(text(), 'Brocolli')]"));
		
		addCart(driver, "Brocolli");
		addCart(driver, "Cucumber");


}
	
	public static void addCart(WebDriver driver, String Vegetable) {
		WebElement veggie = driver.findElement(By.xpath("//div[@class='product']/h4[contains(text(), '"+Vegetable+"' )]"));
		veggie.findElement(By.xpath("parent::div//button")).click();	
	}
}
