package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(id="qccombo")
	private WebElement dropDown;
	
	@FindBy(linkText="Campaigns")
	private WebElement CampaignLnk;
	
	@FindBy(linkText="Products")
	private WebElement productsLnk;
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createImg;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreLnk;
	
	@FindBy(name="Vendors")
	private WebElement vendorLnk;
	
	@FindBy(linkText="Leads")
	private WebElement leadLnk;
	
	@FindBy(linkText="Calendar")
	private WebElement caledarLnk;
	
	@FindBy(linkText="Organizations")
	private WebElement orgLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLnk;
	@FindBy(linkText="Opportunities")
	private WebElement oppLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLnk;
	
	@FindBy(id="qccombo")
	private WebElement quickcreateDp;
	
	public WebElement getQuickcreateDp() {
		return quickcreateDp;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getCreateImg() {
		return createImg;
	}

	public WebElement getCampaignLnk() {
		return CampaignLnk;
	}

	public void setCampaignLnk(WebElement campaignLnk) {
		CampaignLnk = campaignLnk;
	}

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDropDown() {
		return dropDown;
	}

	public WebElement getMoreLnk() {
		return moreLnk;
	}

	public WebElement getVendorLnk() {
		return vendorLnk;
	}

	public WebElement getLeadLnk() {
		return leadLnk;
	}

	public WebElement getCaledarLnk() {
		return caledarLnk;
	}

	public WebElement getOppLnk() {
		return oppLnk;
	}

	public WebElement getOrgLnk() {
		return orgLnk;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getSignoutImg() {
		return signoutImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	public void clickOrgLnk() 
	{
		orgLnk.click();	
	}
	public void clickOnContactLnk() {
		contactLnk.click();
	}
	public void clickonSignOut() {
		signoutLnk.click();
	}
	public void clickOnCalendarLnk() {
		caledarLnk.click();
	}
	public void clickOnCampaignLnk() {
		CampaignLnk.click();
	}
	public void clickOnLeadLnk() {
		leadLnk.click();
	}
	public void clickOnProductLnkAndClickOnCreateImg() {
		productsLnk.click();
		createImg.click();
	}
	public void clickOnVendorLnk() {
		vendorLnk.click();
	}
	public void clickOnOppLnk() {
		oppLnk.click();
	}
}
