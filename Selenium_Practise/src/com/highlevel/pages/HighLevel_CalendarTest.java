package com.highlevel.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HighLevel_CalendarTest extends Utility {
	
	public static WebDriver driver;
	
	
	@AfterTest
	public void close_browser() {
		//driver.quit();
	}
	
	@Test
	public static void calendarTest() throws InterruptedException, ParseException, IOException {	
		Properties prop = new Properties();
		String path = System.getProperty("user.dir")+"/resources/app_deatils.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		String chrome_driver_path = prop.getProperty("chrome_driver_path");
		String timeout = prop.getProperty("timeout");
		
		
		System.out.println(url+"----"+username+"----"+password+"---------"+chrome_driver_path);
		
		driver = invoke_browser(browser,chrome_driver_path, Long.parseLong(timeout));
		
		HighLevelLoginPage login = new HighLevelLoginPage(driver);
		login.Login_to_application(url, username, password);
		
		
		HighLevelHomePage home = new HighLevelHomePage(driver);
		home.go_to_settings();
		
		String Account_time_zone = home.get_Acc_timezone();
		System.out.println(Account_time_zone);
		String parent_window = driver.getWindowHandle();
		home.go_to_appointment_page(parent_window);
	
		HighLevelAppointmentPage apt_page = new HighLevelAppointmentPage(driver);		
		ArrayList<String> all_timezones = apt_page.get_all_timezones();
		 Collections.shuffle(all_timezones);
		 String selected_timezone = all_timezones.get(0);
		 System.out.println("selected time zone is: " +selected_timezone);
		 apt_page.select_the_timezone(selected_timezone);
		 String date_value = apt_page.select_and_get_appointment_date();
		 String time_value = apt_page.select_and_get_appointment_time_slot();
		 apt_page.continue_appointment(); 
		
		 HighLevelAptUserPage user_page = new HighLevelAptUserPage(driver);
		 HashMap<String, String> user_data = generate_user_data();
		 user_page.schedule_appointment(user_data);
		 
		 HighLevelAptConfirmationPage confirm_page = new HighLevelAptConfirmationPage(driver);
		 Assert.assertEquals(confirm_page.get_Confirmation_Message(), "Your Meeting has been Scheduled");
		 System.out.println(confirm_page.get_Appointment_dateTime());
		 System.out.println(date_value);
		 System.out.println(time_value);
		 Assert.assertTrue(confirm_page.get_Appointment_dateTime().contains(date_value));
		 Assert.assertTrue(confirm_page.get_Appointment_dateTime().contains(time_value));
		 Assert.assertEquals(confirm_page.get_Appointment_TimeZone(), selected_timezone);
		 
		 driver.switchTo().window(parent_window);
		 HighLevelViewCalendarPage view_apt_page = new HighLevelViewCalendarPage(driver);
		 String actual_time = view_apt_page.get_appointment_confirmed_time(user_data.get("first_name")+" "+user_data.get("last_name"));
		 System.out.println(actual_time);
		 String expected_time = get_local_appointment_time(date_value, time_value, selected_timezone);
		 System.out.println(expected_time);
		 Assert.assertEquals(actual_time, expected_time);
	}
}
