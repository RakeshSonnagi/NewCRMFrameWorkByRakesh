package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEventform {

	@FindBy(id="activitytype")
	private WebElement eventtype;
	
	@FindBy(name="subject")
	private WebElement eventname;
	
	@FindBy(xpath="//select[@name='availableusers']/option[text()='Bill Gates']")
	private WebElement availableUser;
	
	@FindBy(name="date_start")
	private WebElement startDate;

	@FindBy(name="due_date")
	private WebElement endDate;
	
	@FindBy(xpath="//input[@value='Add >>']")
	private WebElement addBtn;
	
	@FindBy(xpath="//input[@alt='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public AddEventform(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getEventtype() {
		return eventtype;
	}

	public WebElement getEventname() {
		return eventname;
	}

	public WebElement getAvailableUser() {
		return availableUser;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}
	
}

