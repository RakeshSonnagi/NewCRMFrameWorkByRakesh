package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {

	
	@FindBy(xpath="//td[@class='calAddButton']")
	private WebElement addBtn;
	
	@FindBy(xpath="//a[text()='Meeting']")
	private WebElement meetingLnk;
	
	public CalendarPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getMeetingLnk() {
		return meetingLnk;
	}
	
	
}
