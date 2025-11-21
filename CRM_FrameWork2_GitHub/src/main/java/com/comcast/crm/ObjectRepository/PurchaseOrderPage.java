package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPage {

	@FindBy(name="subject")
	private WebElement subjectEdt;
	
	@FindBy(name="bill_street")
	private WebElement billAddress;

	@FindBy(name="cpy")
	private WebElement copyRadio;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(id="searchIcon1")
	private WebElement searchIcon;
	
	@FindBy(id="qty1")
	private WebElement qtyEdt;
	
	@FindBy(id="listPrice1")
	private WebElement priceEdt;

	public PurchaseOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSubjectEdt() {
		return subjectEdt;
	}

	public WebElement getBillAddress() {
		return billAddress;
	}

	public WebElement getCopyRadio() {
		return copyRadio;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSearchIcon() {
		return searchIcon;
	}

	public WebElement getQtyEdt() {
		return qtyEdt;
	}

	public WebElement getPriceEdt() {
		return priceEdt;
	}

}
