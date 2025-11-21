package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	@FindBy(id="bas_searchfield")
	private WebElement campaignInDp;
	
	@FindBy(name="search_text")
	private WebElement searchField;
	
	@FindBy(name="submit")
	private WebElement searchBtn;
	
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCampaignInDp() {
		return campaignInDp;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	
}
