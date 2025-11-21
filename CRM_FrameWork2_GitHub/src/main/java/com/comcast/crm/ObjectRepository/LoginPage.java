package com.comcast.crm.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement usernameEle;
	
	@FindBy(name="user_password")
	private WebElement passwordEle;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	WebDriver driver; 
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getUsernameEle() {
		return usernameEle;
	}

	public WebElement getPasswordEle() {
		return passwordEle;
	}
	
	public void loginactions(String username, String password)
	{
		usernameEle.sendKeys(username);
		passwordEle.sendKeys(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		loginBtn.click();
	}
	

}
