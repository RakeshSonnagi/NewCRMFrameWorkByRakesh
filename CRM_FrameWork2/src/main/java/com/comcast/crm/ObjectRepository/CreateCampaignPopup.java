package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPopup {

	@FindBy(name = "campaignname")
	private WebElement campaignNameEle;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCampaignNameEle() {
		return campaignNameEle;
	}

	public CreateCampaignPopup(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterCampaignNameAndClickOnSave(String campaignname) {
		campaignNameEle.sendKeys(campaignname);
		saveBtn.click();
	}


}
