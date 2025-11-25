package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createImg;
	
	@FindBy(name="salutationtype")
	private WebElement salutationDp;
	
	@FindBy(name="firstname")
	private WebElement firstNameEdt;
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;

	@FindBy(name="company")
	private WebElement companyNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(linkText="Add Event")
	private WebElement eventLnk;
	
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateImg() {
		return createImg;
	}

	public WebElement getSalutationDp() {
		return salutationDp;
	}

	public WebElement getFirstNameEdt() {
		return firstNameEdt;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getCompanyNameEdt() {
		return companyNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getEventLnk() {
		return eventLnk;
	}
	public void clickOnCreateImg() {
		createImg.click();
	}
	public void enterDetailsOfLead() {
		firstNameEdt.sendKeys("sam");
		lastNameEdt.sendKeys("jam");
		companyNameEdt.sendKeys("HP");
		saveBtn.click();
		eventLnk.click();
	}
	
}
