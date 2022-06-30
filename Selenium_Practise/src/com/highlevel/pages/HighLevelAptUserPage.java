package com.highlevel.pages;


import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HighLevelAptUserPage {
	public static WebDriver driver;
	
	@FindBy(id ="first_name")
	WebElement first_name;
	
	@FindBy(id ="last_name")
	WebElement last_name;
	
	@FindBy(id ="phone")
	WebElement phone;
	
	@FindBy(name ="email")
	WebElement email;
	
	@FindBy(xpath ="//button[text()='Schedule Meeting']")
	WebElement Schedule_Meeting;
	
	
	
	public HighLevelAptUserPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//fill the user form and schedule the appointment
	public void schedule_appointment(HashMap<String, String> user_info) throws InterruptedException {
		first_name.sendKeys(user_info.get("first_name"));
		last_name.sendKeys(user_info.get("last_name"));
		phone.sendKeys(user_info.get("phone"));
		Thread.sleep(2000);
		email.sendKeys(user_info.get("email"));
		Schedule_Meeting.click();		
	}
	
		
	
}
