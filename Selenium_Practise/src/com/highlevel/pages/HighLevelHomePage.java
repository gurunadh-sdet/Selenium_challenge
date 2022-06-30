package com.highlevel.pages;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HighLevelHomePage extends Utility {
	public static WebDriver driver;
	
	@FindBy(xpath ="//span[contains(text(), 'Settings')]")
	WebElement settings;
	
	@FindBy(xpath ="//button[contains(@title,'GMT')]//div[@class ='filter-option-inner-inner']")
	WebElement acc_timezone;
	
	@FindBy(xpath ="//span[contains(text(), 'Calendars')]")
	WebElement caledars;
	
	@FindBy(xpath ="//button[contains(text(), 'automation1/autotest')]")
	WebElement booking_calendar;
	
	public HighLevelHomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public void go_to_settings() throws InterruptedException {
		wait_for_element(driver,  settings);
		settings.click();
	}
	
	public String get_Acc_timezone() {
		return acc_timezone.getText();
	}

	public void go_to_appointment_page(String parent_window) {
		caledars.click();
		booking_calendar.click();
		Set<String> all_handles = driver.getWindowHandles();
		for(String handle: all_handles) {
			if(!handle.equals(parent_window)) {
				driver.switchTo().window(handle);
				break;
			}
		}
	}
	
	
	
}
