package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchPage {

	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[text()='mobiles616']")
	private WebElement selectName;
	
	public ProductSearchPage(WebDriver driver) {
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
	
}
