package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createImg;
	
	@FindBy(name="vendorname")
	private WebElement vendorName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(linkText="Create Purchase Order")
	private WebElement purchaseLnk;
	
	public VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateImg() {
		return createImg;
	}

	public WebElement getVendorName() {
		return vendorName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getPurchaseLnk() {
		return purchaseLnk;
	}
	
}
