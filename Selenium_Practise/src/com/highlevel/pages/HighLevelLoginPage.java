package com.highlevel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HighLevelLoginPage {
	public static WebDriver driver;
	
	@FindBy(id ="email")
	WebElement userName;
	
	@FindBy(id ="password")
	WebElement password;
	
	@FindBy(xpath ="//button[contains(text(),'Sign in')]")
	WebElement login_button;
	
	public HighLevelLoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Login_to_application(String url, String user_name, String passWord) {
		driver.get(url);
		userName.sendKeys(user_name);
		password.sendKeys(passWord);
		login_button.click();
	}

}
