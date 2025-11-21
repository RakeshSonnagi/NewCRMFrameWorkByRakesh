package com.comcast.crm.BaseClassUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.comcast.crm.DatabaseUtility.DataBaseUtility;
import com.comcast.crm.FileUtility.FileUtility;
import com.comcast.crm.JavaUtility.JavaUtility;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.WebDriverUtility.WebDriverUtility;

public class BaseClass {
	public FileUtility flib=new FileUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public DataBaseUtility dblib= new DataBaseUtility();
	public WebDriver driver=null;
	
	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void configBS() throws SQLException 
	{	
		//dblib.getDbConnnection("jdbc:mysql;//49.249.28.218:8888", "admin", "admin%#");
		
	}
	@BeforeTest(groups={"smokeTest","regressionTest"})
	public void configBT()
	{
		
	}
	@BeforeClass(groups={"smokeTest","regressionTest"})
	public void configBC() throws IOException 
	{
		String browser=flib.getDataFromProperties("url");
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else {
			driver= new ChromeDriver();
		}
		
	}
	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void configBM() throws IOException
	{
	
		// get the values from property file
		String url = flib.getDataFromProperties("url");
		String username = flib.getDataFromProperties("username");
		String password = flib.getDataFromProperties("password");
		driver.get(url);
		wlib.maxBrowser(driver);
		wlib.waitForPageToLoad(driver);
		LoginPage lp=new LoginPage(driver);
		lp.loginactions(username, password);
		
	}
	@AfterMethod(groups={"smokeTest","regressionTest"})
	public void configAM() throws InterruptedException 
	{	
		HomePage hp=new HomePage(driver);
		Thread.sleep(2000);
		WebElement signout = hp.getSignoutImg();
		wlib.ActionsMoveToElement(driver, signout);
		Thread.sleep(2000);
		hp.clickonSignOut();
	}
	@AfterClass(groups={"smokeTest","regressionTest"})
	public void configAC() 
	{
		driver.quit();
		
	}
	@AfterTest(groups={"smokeTest","regressionTest"})
	public void configAT() 
	{
		
	}
	@AfterSuite(groups={"smokeTest","regressionTest"})
	public void configAS() throws SQLException 
	{
		//dblib.closeDbConnection();
	}
}
