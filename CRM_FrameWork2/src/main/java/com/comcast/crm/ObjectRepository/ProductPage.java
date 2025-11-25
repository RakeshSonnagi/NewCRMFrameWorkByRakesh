package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	@FindBy(name="productname")
	private WebElement productName;

	@FindBy(name="sales_start_date")
	private WebElement startDate;
	
	@FindBy(name="glacct")
	private WebElement accountDp;
	
	@FindBy(name="sales_end_date")
	private WebElement salesEndDate;
	
	@FindBy(name="usageunit")
	private WebElement unitDp;
	
	@FindBy(id="unit_price")
	private WebElement priceEdt;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement  saveBtn;
	
	@FindBy(xpath="//a[text()='Create Invoice']")
	private WebElement invoiceLnk;
	
	public WebElement getInvoiceLnk() {
		return invoiceLnk;
	}
	public ProductPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getProductName() {
		return productName;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getAccountDp() {
		return accountDp;
	}

	public WebElement getSalesEndDate() {
		return salesEndDate;
	}

	public WebElement getUnitDp() {
		return unitDp;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getPriceEdt() {
		return priceEdt;
	}
	public void enterProductNameWithSupportDate(String productname,String startdate,String endDate ) {
		productName.sendKeys(productname);

		startDate.sendKeys(startdate);
		salesEndDate.sendKeys(endDate);
	} 
	public void enterPriceDetails() {
		priceEdt.clear();
		priceEdt.sendKeys("10");
	}
	public void clickOnSaveBtnAndInvoiceBtn() {
		saveBtn.click();
		invoiceLnk.click();
	}
	
}
