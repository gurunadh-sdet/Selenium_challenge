package com.selenium.practise1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Challenge3 {

	public static void main(String[] args) {
		String Expected_Price="";
	//Setting the driver path
		System.setProperty("webdriver.chrome.driver","/Users/gmitikela/GitRepo/Learnings/Selenium/chromedriver/chromedriver");
		
	//Launching the browser with website url	
		WebDriver driver=new ChromeDriver();  
		driver.get("https://www.saucedemo.com/");
		
	//Login with valid credentials	
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	
		
	//	Find the maximum item price and required WebElement
		List<WebElement> all_item_prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		Double max_item_price =0.0;
		WebElement required_item =null;
		for(WebElement item: all_item_prices){
			
			Double price =Double.parseDouble(item.getText().replace("$", ""));
			if(price>max_item_price) {
				 max_item_price =price;
				 required_item = item;
				 Expected_Price= item.getText();
			}
		}
		
	// Print the maximum item price for reference	
		//System.out.println(max_item_price);
		System.out.println(required_item.getText());
		
	//	Click on add to cart for maximum priced item
		WebElement followingSibling = required_item.findElement(By.xpath("following-sibling::button"));
		followingSibling.click();
		
	// Check the cart_contaner for the added item	
		WebElement cart_container = driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a"));
		System.out.println(cart_container.getText()); //we can add an assertion to be "1"
		cart_container.click();
		WebElement added_item = driver.findElement(By.xpath("//div[@class='inventory_item_price']"));
		System.out.println(added_item.getText());   //We can add an assertion to equal the maximum price we have already
		Assert.assertEquals(added_item.getText(), Expected_Price);
				

}
}
