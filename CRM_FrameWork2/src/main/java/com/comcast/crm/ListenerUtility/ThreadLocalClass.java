package com.comcast.crm.ListenerUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ThreadLocalClass {
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> tdriver=new ThreadLocal<WebDriver>();
	public static ExtentTest getTest() {
		return test.get();
	}
	public static void setTest(ExtentTest acttest) {
		test.set(acttest);
	}
	public static WebDriver getTdriver() {
		return tdriver.get();
	}
	public static void setTdriver(WebDriver acttdriver) {
		tdriver.set(acttdriver);;
	}

}
