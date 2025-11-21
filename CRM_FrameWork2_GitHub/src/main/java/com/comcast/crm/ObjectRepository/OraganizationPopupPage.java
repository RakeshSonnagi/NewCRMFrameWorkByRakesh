package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OraganizationPopupPage {
	
	@FindBy(id="search_txt")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[text()='WhatsApp_187']")
	private WebElement selectName;
	
	public OraganizationPopupPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSelectName() {
		return selectName;
	}
	public void searchOrgAndSelectOrgAndClickOnSave(String orgName) {
		searchEdt.sendKeys(orgName);
		searchBtn.click();
	selectName.click();
	}
	
	
}
