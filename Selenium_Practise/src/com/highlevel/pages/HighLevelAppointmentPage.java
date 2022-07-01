package com.highlevel.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HighLevelAppointmentPage extends Utility{
	public static WebDriver driver;
	
	@FindBy(xpath ="//div[@class='multiselect__content-wrapper']//li//span[@class='option__title']")
	List<WebElement> timezones_list;
	
	@FindBy(xpath ="//div[@class='widgets-timezone-picker']")
	WebElement timezone_dropdown;
	
	@FindBy(xpath ="(//table//tr//td[contains(@class, 'selectable')])[1]")//selecting next day as appointment
	WebElement selecting_date;
	
	@FindBy(xpath ="(//div[@class='widgets-slot-block']//li/span)[1]")
	WebElement selecting_slot;
	
	@FindBy(xpath ="//div[contains(@class,'datetime')]/div")
	WebElement apt_date;
	
	@FindBy(xpath ="//button[text()='Continue']")
	WebElement continue_button;
	
	private WebElement get_timezone(String selected_timezone) {
	 return driver.findElement(By.xpath("//ul[@class='multiselect__content']//span[contains(text(), '"+selected_timezone+"')]"));
	}
		
	
	public HighLevelAppointmentPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public ArrayList<String> get_all_timezones() {
		ArrayList<String> all_timezones = new ArrayList<String>();
		for(WebElement ele:timezones_list) {
			all_timezones.add(ele.getAttribute("innerText"));
			//System.out.println(ele.getAttribute("innerText"));
		}
		return all_timezones;
	}
	
	public void select_the_timezone(String selected_timezone) {
		timezone_dropdown.click();
		get_timezone(selected_timezone).click();
		
	}
	
	public String select_and_get_appointment_date() throws InterruptedException {
		selecting_date.click();
		wait_for_element(driver,apt_date);
		return apt_date.getText().trim();		
	}
	
	public String select_and_get_appointment_time_slot() throws InterruptedException {
		selecting_slot.click();
		wait_for_element(driver,selecting_slot);
		return selecting_slot.getText().trim();
	}
	
	public void continue_appointment() {
		continue_button.click();
	}
		
	
	
}
