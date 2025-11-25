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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.comcast.crm.DatabaseUtility.DataBaseUtility;
import com.comcast.crm.FileUtility.FileUtility;
import com.comcast.crm.JavaUtility.JavaUtility;
import com.comcast.crm.ListenerUtility.ThreadLocalClass;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.WebDriverUtility.WebDriverUtility;

public class BaseClass {
	public FileUtility flib=new FileUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public DataBaseUtility dblib= new DataBaseUtility();
	public static WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void configBS() throws SQLException 
	{	
		//dblib.getDbConnnection("jdbc:mysql;//49.249.28.218:8888", "admin", "admin%#");
		
	}
	@BeforeTest(groups={"smokeTest","regressionTest"})
	public void configBT()
	{
		
	}
	@Parameters("Browser")
	@BeforeClass(groups={"smokeTest","regressionTest"})
	public void configBC(@Optional("chrome")String Browser) throws IOException 
	{
		//String browser=Browser;
		String browser=System.getProperty("Browser");
		//String browser=flib.getDataFromProperties("url");
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
		//sdriver=driver;
		ThreadLocalClass.setTdriver(driver);
		
	}
	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void configBM() throws IOException, InterruptedException
	{
		String url=System.getProperty("url",flib.getDataFromProperties("url"));
		String username=System.getProperty("username",flib.getDataFromProperties("username"));
		String password=System.getProperty("password",flib.getDataFromProperties("password"));
		// get the values from property file
		//String url = flib.getDataFromProperties("url");
		//String username = flib.getDataFromProperties("username");
		//String password = flib.getDataFromProperties("password");
		driver.get(url);
		wlib.maxBrowser(driver);
		wlib.waitForPageToLoad(driver);
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(2000);		
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
