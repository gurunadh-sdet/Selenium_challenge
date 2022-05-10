package com.selenium.practise1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FlightsTest {

	public static void main(String[] args) throws InterruptedException {
		String Expected_Price="";
	//Setting the driver path
		System.setProperty("webdriver.chrome.driver","/Users/gmitikela/GitRepo/Learnings/Selenium/chromedriver/chromedriver");
		
	//Launching the browser with website url	
		WebDriver driver=new ChromeDriver();  
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		

	WebElement currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	Select currency_dropdown = new Select(currency);
	currency_dropdown.selectByVisibleText("USD");
	Assert.assertEquals(currency_dropdown.getFirstSelectedOption().getText(), "USD");
	
	WebElement passengers = driver.findElement(By.id("divpaxinfo"));
	int count =0;
	passengers.click();
	Thread.sleep(2000);
	while(count<3) {
	driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
	 count = Integer.parseInt(driver.findElement(By.id("spanAudlt")).getText());
	}

}
}
