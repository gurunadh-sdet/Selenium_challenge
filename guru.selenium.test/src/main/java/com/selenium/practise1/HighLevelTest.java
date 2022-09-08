package com.selenium.practise1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



// This is sample test
public class HighLevelTest {
	
	public static WebDriver driver;
	
	
	@Test
	public static void Testcase1() throws InterruptedException, ParseException {

	System.setProperty("webdriver.chrome.driver" ,"/Users/gmitikela/GitRepo/Selenium_challenge/browser_drivers/chromedriver/chromedriver");
	
	HashMap<String, Object> prefs = new HashMap<String, Object>();
	//Pass the argument 1 to allow the notifications and 2 to block the notifications
	prefs.put("profile.default_content_setting_values.notifications", 2);
	ChromeOptions options = new ChromeOptions();
	// set ExperimentalOption - prefs 
	options.setExperimentalOption("prefs", prefs);
	driver =new ChromeDriver(options);	
	driver.get("https://app.gohighlevel.com");
	WebElement userName = driver.findElement(By.id("email"));
	WebElement password = driver.findElement(By.id("password"));
	WebElement login_button = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
	userName.sendKeys("gurusamrat973@gmail.com");
	password.sendKeys("Test@123");
	login_button.click();
	
	
	
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	//WebElement settings = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Settings')]")));
	Thread.sleep(30000);
	WebElement settings = driver.findElement(By.xpath("//span[contains(text(), 'Settings')]"));
	settings.click();

	
	Thread.sleep(10000);
	WebElement time_zone = driver.findElement(By.xpath("//button[contains(@title,'GMT')]//div[@class ='filter-option-inner-inner']"));
	String Account_time_zone = time_zone.getText();
	System.out.println(Account_time_zone);

	//String appointment_time_zone ="GMT-07:00 America/Dawson (GMT-7)";
	WebElement calendars = driver.findElement(By.xpath("//span[contains(text(), 'Calendars')]"));
	calendars.click();
	Thread.sleep(5000);
	String parent_window = driver.getWindowHandle();
	WebElement booking_calendar = driver.findElement(By.xpath("//button[contains(text(), 'automation1/autotest')]"));
	booking_calendar.click();
	Thread.sleep(5000);
	Set<String> all_handles = driver.getWindowHandles();
	
	for(String handle: all_handles) {
		if(!handle.equals(parent_window)) {
			driver.switchTo().window(handle);
			break;
		}
	}
	
	ArrayList<String> all_timezones = new ArrayList<String>();
	List<WebElement> all_ele = driver.findElements(By.xpath("//div[@class='multiselect__content-wrapper']//li//span[@class='option__title']"));
	for(WebElement ele:all_ele) {
		all_timezones.add(ele.getAttribute("innerText"));
		System.out.println(ele.getAttribute("innerText"));
	}
	 Collections.shuffle(all_timezones);
	 String selected_timezone = all_timezones.get(0);
	 System.out.println("selected time zone is" +selected_timezone);
	
	 Thread.sleep(5000);
	WebElement timezone_dropdown = driver.findElement(By.xpath("//div[@class='widgets-timezone-picker']"));
	timezone_dropdown.click();
	 Thread.sleep(3000);
	//timezone_dropdown.sendKeys(selected_timezone);
	//timezone_dropdown.sendKeys(Keys.ENTER);
	WebElement pick_timezone = driver.findElement(By.xpath("//ul[@class='multiselect__content']//span[contains(text(), '"+selected_timezone+"')]"));
	pick_timezone.click();
	
	WebElement todays_date = driver.findElement(By.xpath("//table//tr//td[contains(@class, 'today')]"));
	WebElement selecting_date = driver.findElement(By.xpath("(//table//tr//td[contains(@class, 'selectable')])[2]"));
	selecting_date.click();
	 Thread.sleep(1000);
	String date_value = driver.findElement(By.xpath("//div[contains(@class,'datetime')]/div")).getText().trim();
	 Thread.sleep(1000);
	WebElement selecting_slot = driver.findElement(By.xpath("(//div[@class='widgets-slot-block']//li/span)[1]"));
	String time_value = selecting_slot.getText().trim();
	selecting_slot.click();
	System.out.println("time value "+time_value);
	WebElement continue_button = driver.findElement(By.xpath("//button[text()='Continue']"));
	continue_button.click();
	 Thread.sleep(5000);
	WebElement first_name = driver.findElement(By.id("first_name"));
	WebElement last_name = driver.findElement(By.id("last_name"));
	WebElement phone = driver.findElement(By.id("phone"));
	WebElement email = driver.findElement(By.name("email"));
	WebElement Schedule_Meeting = driver.findElement(By.xpath("//button[text()='Schedule Meeting']"));
	
	first_name.sendKeys("Xyz");
	last_name.sendKeys("Abc");
	phone.sendKeys("6756784567");
	email.sendKeys("xyz123@gmail.com");
	Schedule_Meeting.click();
	 Thread.sleep(10000);

	String confirmation_text = driver.findElement(By.tagName("h5")).getText();//Your Meeting has been Scheduled
	String duration = driver.findElement(By.xpath("//div[contains(@class,'duration')]/div")).getText().trim();
	String date_time = driver.findElement(By.xpath("//div[contains(@class,'datetime')]/div")).getText().trim();
	String user_timezone = driver.findElement(By.xpath("//div[contains(@class,'timezone')]/div")).getText().trim();
	System.out.println(confirmation_text);
	System.out.println(duration);
	System.out.println(date_time);
	System.out.println(user_timezone);
	driver.switchTo().window(parent_window);
	WebElement back_button = driver.findElement(By.id("backButtonv2"));
	back_button.click();
	 Thread.sleep(5000);
	WebElement calendars_tab = driver.findElement(By.id("sb_calendars"));
	calendars_tab.click();
	 Thread.sleep(2000);
	WebElement appointments_tab =  driver.findElement(By.id("tb_apppontment-tab"));
	appointments_tab.click();
	 Thread.sleep(10000);
	String requested_time = driver.findElement(By.xpath("//h4[text()='Xyz Abc']/parent::div/parent::td/following-sibling::td[1]/div")).getText();
	System.out.println("requested_time==="+requested_time);
	String exected_date_time = get_local_appointment_time(date_value, time_value, user_timezone);
	Assert.assertEquals(requested_time, exected_date_time);
	if(requested_time.equals(exected_date_time)) {
		System.out.println("the test case is passed");
	}else
		System.out.println("The test case is failed as actual time:  "+requested_time+" and expected time are different:"+exected_date_time);
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
	
}
