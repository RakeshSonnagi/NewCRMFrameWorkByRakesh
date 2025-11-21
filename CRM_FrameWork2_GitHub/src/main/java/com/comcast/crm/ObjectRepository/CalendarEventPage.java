package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventPage {
	
	@FindBy(name="activitytype")
	private WebElement activityDp;
	
	@FindBy(name="subject")
	private WebElement EventName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CalendarEventPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getActivityDp() {
		return activityDp;
	}

	public WebElement getEventName() {
		return EventName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

}
