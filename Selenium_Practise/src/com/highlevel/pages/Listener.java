package com.highlevel.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends Utility implements ITestListener {
	WebDriver driver = null;

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testcasename = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			get_screenshot(testcasename, driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
