package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createimg;

	@FindBy(name="accountname")
	private WebElement accName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement actOrgName;
	
	@FindBy(name="industry")
	private WebElement industryDp;
	
	@FindBy(name="accounttype")
	private WebElement accttype; 
	
	@FindBy(id="dtlview_Industry")
	private WebElement actIndustryName;
	
	@FindBy(id="dtlview_Type")
	private WebElement acttypeName;
	
	@FindBy(id="phone")
	private WebElement phoneNumber;
	
	@FindBy(id="dtlview_Phone")
	private WebElement actPhoneNumber;
	
	public OrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateimg() {
		return createimg;
	}

	public WebElement getAccName() {
		return accName;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getActOrgName() {
		return actOrgName;
	}

	public WebElement getIndustryDp() {
		return industryDp;
	}

	public WebElement getActPhoneNumber() {
		return actPhoneNumber;
	}

	public WebElement getAccttype() {
		return accttype;
	}

	public WebElement getActIndustryName() {
		return actIndustryName;
	}

	public WebElement getActtypeName() {
		return acttypeName;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}
	public void clickOnCreateImg() {
		createimg.click();
	}
	public void enterAccountNameAndClickOnSave(String orgName) 
	{
		accName.sendKeys(orgName);
		savebtn.click();
	}
	public void enterAccountName(String orgName) {
		accName.sendKeys(orgName);
	}
	public void clickOnSaveBtn() {
	savebtn.click();
	}
	public void enterPhoneNumberAndClickOnSaveBtn(String phonenum) {
		phoneNumber.sendKeys(phonenum);

		savebtn.click();
	}
	
	
}
