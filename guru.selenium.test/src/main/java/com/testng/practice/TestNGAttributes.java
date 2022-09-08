package com.testng.practice;

import org.testng.annotations.Test;

//@Test
public class TestNGAttributes {

//  By Default for all the tests priority will be 0, so we can give negative value for a test take the precedence over all other tests
	@Test(priority =2)
	public void method1() {
		System.out.println("Test Method1");
	}
	
	@Test(description="this is method2 description")
	public void method2() {
		System.out.println("Test Method2");
	}
	
	@Test(timeOut =3000)// org.testng.internal.thread.ThreadTimeoutException: Method com.selenium.practise1.TestNGFactory.method3() didn't finish within the time-out 1000
	public void method3() throws InterruptedException {
		System.out.println("Test Method3");
		Thread.sleep(2000);
	}
	
	@Test(priority =-1)// This should be executed first
	public void method4() {
		System.out.println("Test Method4");
	}
	
	
	@Test(dependsOnMethods = {"method6"}, alwaysRun =true)// This should be only after successful execution of method6
	public void method5() {
		System.out.println("Test Method5");
	}
	
	@Test()//
	public void method6() {
		System.out.println("Test Method6");
	}
	
	@Test(enabled=false)// This method will be skipped
	public void method7() {
		System.out.println("Test Method7");
	}

	
	@Test(groups="smoke")// 
	public void method8() {
		System.out.println("Test Method8");
	}
	@Test(groups="smoke")// 
	public void method9() {
		System.out.println("Test Method9");
	}
	
	@Test(groups="sanity")// 
	public void method10() {
		System.out.println("Test Method10");
	}
	
	@Test(invocationCount=2)// This method will invoked twice
	public void method11() {
		System.out.println("Test Method11");
	}
	
	@Test(dependsOnGroups= {"smoke", "sanity"})// This method will invoke only when smoke and sanity groups executes
	public void method12() {
		System.out.println("Test Method12");
	}
	
	@Test
	public void method13() {
		System.out.println("Test Method13");
	}
	
	
	
}
	
