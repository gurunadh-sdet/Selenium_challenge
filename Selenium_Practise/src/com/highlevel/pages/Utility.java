package com.highlevel.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.github.javafaker.Faker;

public class Utility {
	public static WebDriver driver;
	
	//Browser will be invoked, currently handled for chrome only and suppress the notifications
	public static WebDriver invoke_browser(String browser, String driverPath, Long timeout) throws IOException {
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver" ,driverPath);
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		//Pass the argument 1 to allow the notifications and 2 to block the notifications
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver =new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		return driver;
		}
		return driver;
	}
	
	
	public void wait_for_element(WebDriver driver, WebElement ele) throws InterruptedException {
		boolean flag = false;
		int timeout = 30;	// this timeout can be passed in element level as well
		int interval =2;
		while(timeout>0) {
			try {
			flag = ele.isDisplayed();	
			}
			catch(Exception e){
				Thread.sleep(interval*1000);
				timeout = timeout - interval;
			}		
		if (flag==true) 
			break;		
		}
	}
	
	//This method will generate the random name, phone and email for user form
	public static HashMap<String, String> generate_user_data() {
		HashMap<String, String> user = new HashMap<String, String>();
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		System.out.println(firstName+" "+lastName);
		user.put("first_name", firstName);
		user.put("last_name", lastName);
		long ph_number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		System.out.println(ph_number);
		user.put("phone", String.valueOf(ph_number));
		user.put("email", firstName+"123@gmail.com");
		return user;		
	}
	
	// This method will convert the user time zone time to account time zone
	public static String get_local_appointment_time(String user_apt_date, String user_apt_time, String user_timezone) throws ParseException {
		String user_date_s = ""+user_apt_date+", "+ ""+user_apt_time+"";
		user_timezone= user_timezone.split(" ")[1];
		SimpleDateFormat dt = new SimpleDateFormat("EEE, MMM d, yyyy, hh:mm a");
		TimeZone user_tz = TimeZone.getTimeZone(user_timezone);
		dt.setTimeZone(user_tz);
		Date date_new = dt.parse(user_date_s);// this will parse the date to current user timezone
		System.out.println(date_new);
		String output_date = new SimpleDateFormat("MMM dd yyyy, hh:mm a").format(date_new); // changing the date our required format
		System.out.println(output_date);
		return output_date;	
	}
	
	public void get_screenshot(String testcasename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"/reports/"+testcasename+".png";
		//String destination = System.getProperty("user.dir")+"/reports/test123.png";
		FileUtils.copyFile(source, new File(destination));				
	}

}
