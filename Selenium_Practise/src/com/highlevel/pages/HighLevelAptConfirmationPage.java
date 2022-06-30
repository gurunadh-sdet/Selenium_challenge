package com.highlevel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HighLevelAptConfirmationPage extends Utility {
	public static WebDriver driver;

	@FindBy(tagName ="h5")
	WebElement confirmation_text;
	
	@FindBy(xpath ="//div[contains(@class,'duration')]/div")
	WebElement duration;
	
	@FindBy(xpath ="//div[contains(@class,'datetime')]/div")
	WebElement date_time;
	
	@FindBy(xpath ="//div[contains(@class,'timezone')]/div")
	WebElement user_timezone;
	
	
	public HighLevelAptConfirmationPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String get_Confirmation_Message() throws InterruptedException {
		wait_for_element(driver, confirmation_text);
		return confirmation_text.getText().trim();	
	}
	
	public String get_Appointment_dateTime() {
		return date_time.getText().trim();	
	}
	
	public String get_Appointment_TimeZone() {
		return user_timezone.getText().trim();	
	}
	
	public String get_Appointment_Duration() {
		return duration.getText().trim();	
	}
			
	
}
