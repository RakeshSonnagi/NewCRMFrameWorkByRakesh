package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPage {

	
	@FindBy(id="bas_searchfield")
	private WebElement searchDp;
	
	
	@FindBy(name="search_text")
	private WebElement searchField;

	@FindBy(name="submit")
	private WebElement searchBtn;
	
	@FindBy(xpath="//td[text()='POT1476 ']/following-sibling::td/a[text()='Zoho']")
	private WebElement oppName;
	
	@FindBy(xpath="//a[text()='Create Invoice']")
	private WebElement createinvoiceLnk;
	
	public OpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchDp() {
		return searchDp;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getOppName() {
		return oppName;
	}

	public WebElement getCreateinvoiceLnk() {
		return createinvoiceLnk;
	}
	public void enterSearchField() {
		searchField.sendKeys("Zoho");
		searchBtn.click();
	}
	public void clickOnInvoiceLnk() {
		createinvoiceLnk.click();
	}
	
	
}
