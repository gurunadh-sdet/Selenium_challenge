package com.highlevel.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HighLevelViewCalendarPage extends Utility {
	public static WebDriver driver;
	
	
	@FindBy(id ="backButtonv2")
	WebElement back_button;
	
	@FindBy(id ="sb_calendars")
	WebElement calendars_tab;
	
	@FindBy(id ="tb_apppontment-tab")
	WebElement appointments_tab;
	
	@FindBy(xpath ="(//td[@id='pg-appt__link-contact-detail']//h4)[1]")
	WebElement contact_name;
	
	private  WebElement requested_time(String user_name) {
	 return driver.findElement(By.xpath("//h4[text()='"+user_name+"']/parent::div/parent::td/following-sibling::td[1]/div"));
	}
	
	
	public HighLevelViewCalendarPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void go_to_home_Page() {
		back_button.click();	
	}
	
	public void go_to_calendars_tab() {
		calendars_tab.click();	
	}
	
	public void go_to_view_appointments_page() {
		appointments_tab.click();	
	}
	
	public String get_contact_name() {
		return contact_name.getText().trim();
	}
	
	public String get_appointment_confirmed_time(String userName) throws InterruptedException {
		go_to_home_Page();
		go_to_calendars_tab();
		go_to_view_appointments_page();
		wait_for_element(driver,requested_time(userName));
		return requested_time(userName).getText().trim();	
	}
			
	
}
