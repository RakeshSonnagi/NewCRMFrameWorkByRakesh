package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {
	
	@FindBy(name="subject")
	private WebElement subjectEdt;

	@FindBy(xpath="//td/textarea[@name='bill_street']")
	private WebElement billAddress;
	
	@FindBy(name="ship_street")
	private WebElement shipAddress;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgName;

	public InvoicePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSubjectEdt() {
		return subjectEdt;
	}

	public WebElement getBillAddress() {
		return billAddress;
	}

	public WebElement getShipAddress() {
		return shipAddress;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrgName() {
		return orgName;
	}	

	
}
