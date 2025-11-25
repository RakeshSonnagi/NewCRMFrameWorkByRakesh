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

	@FindBy(xpath="(//input[@name='cpy'])[2]")
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
	public void enterSubjectFieldAndBillAddAndSelectRadioBtn() throws InterruptedException {
		subjectEdt.sendKeys("newBattery");
		billAddress.click();
		Thread.sleep(2000);
		billAddress.sendKeys("Rajajinagar");
		copyRadio.click();
	}
	public void clickOnSearchIcon() {
		searchIcon.click();
	}
	public void enterQtnAndEnterPriceClickOnSave() {
		qtyEdt.sendKeys("10");
		priceEdt.clear();
		priceEdt.sendKeys("1000");
		saveBtn.click();
	}

}
