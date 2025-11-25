package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createImg;
	
	@FindBy(name="lastname")
	private WebElement lastName;

	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrgNameImg;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="support_start_date")
	private WebElement startDate;
	
	@FindBy(name="support_end_date")
	private WebElement endDate;
	

	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateImg() {
		return createImg;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getSelectOrgNameImg() {
		return selectOrgNameImg;
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
	public void clickOnCreateImg() {
		createImg.click();
	}
	public void enterLastNameAndClickOnOrgImg(String lastname) {
		lastName.sendKeys(lastname);
		selectOrgNameImg.click();
	}
	public void clickOnSaveBtn() {
		saveBtn.click();
	}
	public void enterLastName(String lastname) {
		lastName.sendKeys(lastname);
	}
	public void enterCurrentDateAndEndDate(String currentdate,String supportDate) {
		startDate.clear();
		startDate.sendKeys(currentdate);

		endDate.clear();
		endDate.sendKeys(supportDate);

		saveBtn.click();
	}
	
}
